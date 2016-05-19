package MatchPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AllBets {
	private ArrayList<Bet> bets;
	private FileWriter fileWriter;
	private AllPlayers players;
	private AllMatches matches;

	public AllBets(AllPlayers players, AllMatches matches) {
		bets = new ArrayList<Bet>();
		this.players = players;
		this.matches = matches;
	}

	public void addBet(Bet b) {
		bets.add(b);
	}

	public ArrayList<Bet> getAllBets() {
		return bets;
	}

	public ArrayList<Bet> getAllBetsFromPlayer(Player p) {
		ArrayList<Bet> temp = new ArrayList<Bet>();
		for (Bet b : bets) {
			if (b.getPlayer().equals(p)) {
				temp.add(b);
			}
		}
		return temp;
	}

	public boolean saveToFile() {
		try {
			File file = new File("allbets.txt");
			fileWriter = new FileWriter(file);
			for (Bet b : bets) {
				fileWriter.write(b.getPlayer().getName());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(b.getMatch().getHomeTeam());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(b.getMatch().getAwayTeam());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(b.getMatch().getMatchDay());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(b.getPlacedBet());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.flush();
			}
			fileWriter.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean readFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("allbets.txt"));
			String name;
			while ((name = br.readLine()) != null) {
				Player player = players.getPlayerByName(name);
				String homeTeam = br.readLine();
				String awayTeam = br.readLine();
				int matchDay = Integer.parseInt(br.readLine());
				String placedBet = br.readLine();
				Match match = matches.getMatchByTeams(homeTeam, awayTeam, matchDay);
				Bet bet = new Bet(player, match, placedBet);
				bets.add(bet);
			}
			br.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
