package MatchPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewBets {
	ArrayList<String> bets;
	FileWriter fileWriter;

	public NewBets() {
		bets = new ArrayList<String>();
	}

	public void addBet(Player p, String placedBet) {
		bets.add(p.getName() + " " + placedBet);
	}

	public boolean saveToFile() {
		try {
			File file = new File("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\bets.txt");
			fileWriter = new FileWriter(file);
			for (String s : bets) {
				fileWriter.write(s);
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
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\bets.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				bets.add(line);
			}
			br.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
