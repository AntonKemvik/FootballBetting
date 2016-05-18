package Betting;

import java.io.File;

import API2.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import MatchPack.Match;

public class Login extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] User = req.getParameterValues("username");
		String[] Pass = req.getParameterValues("password");

		if (User[0].equals("nils")) {
			PreMatchCompiler pre = new PreMatchCompiler();
			ArrayList<Match> matches = pre
					.run(new URL(
							"http://api.football-data.org/v1/soccerseasons/400/fixtures?matchday=39"));
			File input = new File(
					"C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\homepage.html");
			Document doc = Jsoup.parse(input, null);
			for (int i = 0; i < 10; i++) {
				Element content = doc.getElementById("match" + (i + 1));
				content.attr("style", "display:visible");
				content.child(0).text("league");
				content.child(1).text(matches.get(i).getDate());
				content.child(2).text(matches.get(i).getHomeTeam());
				content.child(3).text(matches.get(i).getAwayTeam());
			}
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		} else {
			File input = new File(
					"C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			Element content = doc.getElementById("normalText");
			content.html("Wrong username or password");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		}
	}
}
