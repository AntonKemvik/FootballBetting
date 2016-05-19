package MatchPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AllPlayers {
	private ArrayList<Player> players;
	private FileWriter fileWriter;

	public AllPlayers() throws FileNotFoundException {
		players = new ArrayList<Player>();
	}

	public ArrayList<Player> getAllPlayers() {
		return players;
	}

	public ArrayList<Player> getScoreboard() {
		ArrayList<Player> temp = new ArrayList<Player>();
		temp.addAll(players);
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

	public Player getPlayerByName(String name) {
		for (Player p : players) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public boolean writeToFile() {
		try {
			File file = new File("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\AllPlayers.txt");
			fileWriter = new FileWriter(file);
			for (int i = 0; i < players.size(); i++) {
				fileWriter.write(players.get(i).getName() + " ");
				fileWriter.write(players.get(i).getPassword() + " ");
				fileWriter.write(players.get(i).getPoints() + "");
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
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\AllPlayers.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				int index = line.indexOf(" ");
				String name = line.substring(0, index);
				int lastIndex = line.lastIndexOf(" ");
				String pw = line.substring(index + 1, lastIndex);

				int points = Integer.parseInt(line.substring(lastIndex + 1));
				players.add(new Player(name, pw, points));
			}
			br.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
