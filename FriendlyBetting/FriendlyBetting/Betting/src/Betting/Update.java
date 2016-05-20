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

public class Update extends HttpServlet {

	protected static Player activeuser;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Results result = new Results();
		result.readFromFile();
		ArrayList<String> allCorrectBets = result.getResults();
		MatchCompiler pre = new MatchCompiler(result);
		ArrayList<Match> matches;
		NewBets allBets = new NewBets();
		allBets.readFromFile();
		ArrayList<String> bets = allBets.getAllBets();
		AllPlayers players = new AllPlayers();
		players.readFromFile();

		for (int i = 0; i < bets.size(); i++) {
			int start = bets.get(i).indexOf(" ");
			String player = bets.get(i).substring(0, start);
			Player p = players.getPlayerByName(player);
			String placedBet = bets.get(i).substring(start + 1);
			String correctBet = allCorrectBets.get(i % 11);
			if (correctBet.equals(placedBet)) {
				p.addPoint();
			}
		}
		ArrayList<Player> leaderPlayers = players.getScoreboard();

		try {
			matches = pre
					.run(new URL(
							"http://api.football-data.org/v1/soccerseasons/400/fixtures?matchday=39"));
			result.readFromFile();
			File input = new File(
					"C:\\Users\\Stoffe\\FriendlyBetting\\Betting\\WebContent\\homepage.html");
			Document doc = Jsoup.parse(input, null);
			System.out.print(matches.size());
			for (int i = 0; i < matches.size(); i++) {
				Element content = doc.getElementById("match" + (i + 1));
				content.attr("style", "display:visible");
				content.child(0).text("league");
				content.child(1).text(matches.get(i).getDate());
				content.child(2).text(matches.get(i).getHomeTeam());
				content.child(3).text(matches.get(i).getAwayTeam());
			}
			for (int i = 0; i < 4; i++) {
				Element content = doc.getElementById("rank" + (i + 1));
				content.child(1).text(leaderPlayers.get(i).getName());
				content.child(2).text(
						Integer.toString(leaderPlayers.get(i).getPoints()));
			}
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
