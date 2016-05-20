package Betting;

import java.io.File;
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
import MatchPack.NewBets;
import MatchPack.Player;

public class PlaceBets extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<String> bets = new ArrayList<String>();
		for (int i = 0; i < 12; i++) {
			String[] Bet = req.getParameterValues("valueselect" + (i + 1));
			if (Bet[0].equals("9")) {
				break;
			}
			bets.add(Bet[0]);
		}
		NewBets nBet = new NewBets();
		nBet.readFromFile();
		for (String s : bets) {
			nBet.addBet(Login.activeuser, s);
		}
		nBet.saveToFile();
		File input = new File(
				"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\login.html");
		Document doc = Jsoup.parse(input, null);
		Element content = doc.getElementById("normalText");
		content.html("You have successfully placed bets");
		PrintWriter output = resp.getWriter();
		output.write(doc.html());
		output.close();
	}
}
