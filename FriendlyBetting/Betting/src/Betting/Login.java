package Betting;

import java.io.File;

import API2.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import MatchPack.*;

public class Login extends HttpServlet {

	protected static Player activeuser;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] User = req.getParameterValues("username");
		String[] Pass = req.getParameterValues("password");

		AllPlayers loginplayer = new AllPlayers();
		loginplayer.readFromFile();
		Player user = loginplayer.getPlayerByName(User[0]);

		if (user != null && user.getPassword().equals(Pass[0])) {
			Results result = new Results();
			MatchCompiler pre = new MatchCompiler(result);
			ArrayList<Match> matches;
			try {
				matches = pre
						.run(new URL(
								"http://api.football-data.org/v1/soccerseasons/400/fixtures?matchday=38"));
				result.saveToFile();
				File input = new File(
						"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\homepage.html");
				Document doc = Jsoup.parse(input, null);
				for (int i = 0; i < 11; i++) {
					Element content = doc.getElementById("match" + (i + 1));
					content.attr("style", "display:visible");
					content.child(0).text("Segunda división");
					content.child(1).text(matches.get(i).getDate());
					content.child(2).text(matches.get(i).getHomeTeam());
					content.child(3).text(matches.get(i).getAwayTeam());
				}
				PrintWriter output = resp.getWriter();
				output.write(doc.html());
				output.close();
				activeuser = user;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File input = new File(
					"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			Element content = doc.getElementById("normalText");
			content.html("Wrong username or password");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		}
	}
}
