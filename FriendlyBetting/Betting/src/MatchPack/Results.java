package MatchPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results {
	ArrayList<String> bets;
	FileWriter fileWriter;
	public Results(){
		bets = new ArrayList<String>();
	}
	
	public void addBet(String placedBet) {
		bets.add(placedBet);
	}

	public boolean saveToFile() {
		try {
			File file = new File("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\correctBets.txt");
			fileWriter = new FileWriter(file);
			for (String s : bets) {
				fileWriter.write(s);
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
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Stoffe\\Desktop\\Ny mapp\\correctBets.txt"));
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
	public ArrayList<String> getResults(){
		return bets;
	}
}
