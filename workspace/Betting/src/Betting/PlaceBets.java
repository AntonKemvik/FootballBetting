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

import API2.PreMatchCompiler;
import MatchPack.Match;
import MatchPack.NewBets;
import MatchPack.Player;

public class PlaceBets extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// File input = new File(
		// "C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\homepage.html");
		// Document doc = Jsoup.parse(input, null);
		// Element script = doc.getElementById("script1");
		// System.out.print(script.text());
		// System.out.print(".html===" + script.html());
		ArrayList<String> bets = new ArrayList<String>();
		for (int i = 0; i < 12; i++) {
			String[] Bet = req.getParameterValues("valueselect" + (i+1));
			System.out.println("Våra bets:" + Bet[0] +" nästa bet: ");
			if (Bet[0].equals("9")){
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
					"C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			Element content = doc.getElementById("normalText");
			content.html("You have successfully placed bets");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
			// for (String i : bets) {
			// System.out.println(i);
			// }
			// System.out.print(Login.activeuser.getName());

		}
	}
