package MatchPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AllPlayers {
	private ArrayList<Player> players;
	private PrintWriter outer;
	private BufferedReader inner;

	public AllPlayers() throws FileNotFoundException {
		players = new ArrayList<Player>();
		PrintWriter outer = new PrintWriter("leaderboard.txt");
		BufferedReader inner = new BufferedReader(new FileReader("leaderboard.txt"));
	}

	public ArrayList<Player> getAllPlayers() {
		return players;
	}

	public ArrayList<Player> getScoreboard() {
		ArrayList<Player> temp = players;
		ArrayList<Player> returnTemp = new ArrayList<Player>();
		while (temp.size() > 0) {
			int index = 0;
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getPoints() > temp.get(index).getPoints()) {
					index = i;
				}
			}
			returnTemp.add(temp.remove(index));
		}
		return returnTemp;
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void saveToFile() {
		for (int i =0; i< players.size(); i++) {
			System.out.println("in");
			outer.println(players.get(i).getName());
			outer.println(players.get(i).getPoints());
		}
		outer.close();
	}
	public void readFromFile() throws IOException{
		String s;
		int t;
		while(( s = inner.readLine())!=null){
			t = Integer.parseInt(inner.readLine());
			players.add(new Player(s,t));
			
		}
		
	}
}
