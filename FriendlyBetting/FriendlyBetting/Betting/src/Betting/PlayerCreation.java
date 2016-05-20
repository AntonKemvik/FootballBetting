package Betting;

import java.io.File;
import java.io.FileNotFoundException;
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

import MatchPack.AllPlayers;
import MatchPack.Match;
import MatchPack.Player;

public class PlayerCreation extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] User = req.getParameterValues("cUsername");
		String[] Pass = req.getParameterValues("cPassword");
		String[] Address = req.getParameterValues("cEmailaddress");

		AllPlayers checkusers = new AllPlayers();
		checkusers.readFromFile();
		if (checkusers.getPlayerByName(User[0]) == null) {

			AllPlayers allplayers;
			try {
				allplayers = new AllPlayers();
				allplayers.readFromFile();
				allplayers.addPlayer(new Player(User[0], Pass[0], 0));
				allplayers.writeToFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File input = new File(
					"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			Element content = doc.getElementById("normalText");
			content.html("Account created");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		} else {
			File input = new File(
					"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			Element content = doc.getElementById("normalText");
			content.html("User already exists");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		}
	}
}
