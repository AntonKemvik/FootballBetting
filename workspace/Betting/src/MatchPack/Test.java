package MatchPack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static void main(String[] args) throws IOException {
		URL test = new URL("http://api.football-data.org/v1/soccerseasons/398/fixtures?matchday=35");
		URLConnection myUrlCon = test.openConnection();
		myUrlCon.addRequestProperty("X-Auth-Token", "8694272ad6134ac2995601c6a46c1f68");
		InputStream is = myUrlCon.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		Player p1 = new Player("Isak", "pw" , 0);
		Player p2 = new Player("Nils", "pw", 0);
		Player p3 = new Player("Anton", "pw", 0);
		Player p4 = new Player("Kringlan", "pw", 0);
		AllPlayers players = new AllPlayers();
		AllMatches matches = new AllMatches();
		Match match = new Match("hemma", "borta", "datum", 39, 0, 0, "Played");
		matches.addMatch(match);
		AllBets bets = new AllBets(players, matches);
		bets.addBet(new Bet(p1, match, "1" ));
		bets.addBet(new Bet(p2, match, "1" ));
		
		System.out.println(bets.saveToFile());
		players.addPlayer(p2);
		players.addPlayer(p4);
		players.addPlayer(p3);
		players.addPlayer(p1);
	
		
		if(players.writeToFile()){
			System.out.println("Saving completed");
		}
		
		// ALLTID LÄSA IN SPELARNA & MATCHERNA INNAN BETTEN. ANNARS KRASCH
//		if(players.readFromFile()){
//			System.out.println("Loading compleded");
//		}
//		for(Player p: players.getAllPlayers()){
//			System.out.println(p.getName() + " " + p.getPassword() + " " + p.getPoints());
//		}
	
		
		
		
		
//		for (Player p : players.getScoreboard()) {
//			System.out.println(p.getName() + " " + p.getPoints());
//		}
//		for ( Player p : players.getAllPlayers()){
//			System.out.println(p.getName() + p.getPoints());
//		}
//		players.saveToFile();
	}
}
