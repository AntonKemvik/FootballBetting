package API2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import MatchPack.*;

public class Main {

	public static void main(String[] args) throws IOException {
		URL test = new URL("http://api.football-data.org/v1/soccerseasons/400/fixtures?matchday=36");
		URLConnection myUrlCon = test.openConnection();
		myUrlCon.addRequestProperty("X-Auth-Token", "8694272ad6134ac2995601c6a46c1f68");
		InputStream is = myUrlCon.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		Results result = new Results();
		MatchCompiler ls = new MatchCompiler(result);
		ArrayList<Match> compiledMatches = ls.run(test);
		result.saveToFile();
		
//		AllPlayers players = new AllPlayers();
//		players.readFromFile();
//		
//		AllMatches matches = new AllMatches();
//		matches.readFromFile();
//		for(Match m: compiledMatches){
//			matches.addMatch(m);
//		}
		
//		AllBets bets = new AllBets(players, matches);
//		bets.readFromFile();
		
//		Player p1 = new Player("Isak", "pw" , 0);
//		Player p2 = new Player("Nils", "pw", 0);
//		Player p3 = new Player("Anton", "pw", 0);
//		Player p4 = new Player("Kringlan", "pw", 0);
//		players.addPlayer(p2);
//		players.addPlayer(p4);
//		players.addPlayer(p3);
//		players.addPlayer(p1);
//		
//		players.writeToFile();
//		matches.writeToFile();
		
//		bets.addBet(new Bet(p1, matches.getMatchByTeams("CA Osasuna", "CD Numancia de Soria", 39), "1" ));
//		bets.addBet(new Bet(p2, matches.getMatchByTeams("CA Osasuna", "CD Numancia de Soria", 39), "2" ));
//		
//		bets.saveToFile();
		
		
		
		
		


	}
	}


