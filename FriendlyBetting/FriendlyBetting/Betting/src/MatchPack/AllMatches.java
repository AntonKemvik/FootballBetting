package MatchPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class AllMatches {
	ArrayList<Match> matches;
	Calendar cal;
	StringBuilder sb;
	FileWriter fileWriter;
	File file;

	public AllMatches() throws IOException {
		cal = Calendar.getInstance();
		matches = new ArrayList<Match>();
		file = new File("allmatches.txt");
		fileWriter = new FileWriter(file);
	}

	public void addMatch(Match match) {
		matches.add(match);
	}

	public void removeMatch(Match match) {
		matches.remove(match);
	}

	@SuppressWarnings({ "deprecation" })
	public String getCurrentDate() {
		sb = new StringBuilder();
		sb.append(1900 + cal.getTime().getYear() + "-");
		if (cal.getTime().getMonth() < 10) {
			sb.append(0);
		}
		sb.append(cal.getTime().getMonth() + "-");
		if (cal.getTime().getDate() < 10) {
			sb.append(0);
		}
		sb.append(cal.getTime().getDate() + "T");
		sb.append(cal.getTime().getHours() - 2 + ":");
		sb.append(cal.getTime().getMinutes() + ":");
		sb.append(cal.getTime().getSeconds() + "Z");
		return sb.toString();
	}

	public ArrayList<Match> getAllMatchesFromMatchDay(int matchDay) {
		ArrayList<Match> temp = new ArrayList<Match>();
		for (Match m : matches) {
			if (m.getMatchDay() == matchDay) {
				temp.add(m);
			}
		}
		return temp;
	}

	public Match getMatchByTeams(String homeTeam, String awayTeam, int matchDay) {
		for (Match m : matches) {
			if (m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam) && m.getMatchDay() == matchDay) {
				return m;
			}
		}
		return null;
	}

	public boolean writeToFile() {
		try {
			for (Match m : matches) {
				fileWriter.write(m.getHomeTeam());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getAwayTeam());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getDate());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getMatchDay());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getHomeGoals());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getAwayGoals());
				fileWriter.write(System.getProperty("line.separator"));
				fileWriter.write(m.getStatus());
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
			BufferedReader br = new BufferedReader(new FileReader("allmatches.txt"));
			String homeTeam;
			while ((homeTeam = br.readLine()) != null) {
				String awayTeam = br.readLine();
				String date = br.readLine();
				int matchDay = Integer.parseInt(br.readLine());
				int homeGoals = Integer.parseInt(br.readLine());
				int awayGoals = Integer.parseInt(br.readLine());
				String status = br.readLine();
				Match match = new Match(homeTeam, awayTeam, date, matchDay, homeGoals, awayGoals, status);
				matches.add(match);
			}
			br.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
