package API2;

import MatchPack.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchCompiler {
	ArrayList<Match> list;
	Results result;

	public MatchCompiler(Results result) {
		list = new ArrayList<Match>();
		this.result = result;
	}

	public ArrayList<Match> run(URL url) {

		try {
			InputStream is = url.openStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
			String line;
			line = bReader.readLine();
			List<String> splitted = Arrays.asList(line.split("links"));

			for (String s : splitted) {
				if (s.contains("homeTeamName") && s.contains("awayTeamName")) {
					int start = s.indexOf("homeTeamName") + 15;
					int stop = s.indexOf("awayTeamName") - 3;
					String home = s.substring(start, stop);

					start = s.indexOf("awayTeamName") + 15;
					stop = s.indexOf("result") - 3;
					String away = s.substring(start, stop);

					start = s.indexOf("date") + 7;
					stop = s.indexOf("status") - 7;
					String date = s.substring(start, stop);
					date = date.replace('T', ' ');

					start = s.indexOf("matchday") + 10;
					stop = s.indexOf("homeTeamName") - 2;
					int matchDay = Integer.parseInt(s.substring(start, stop));

					start = s.indexOf("goalsHomeTeam") + 15;
					stop = s.indexOf("goalsHomeTeam") +16;
					String homeG = s.substring(start, stop);
					int hometeamGoals;
					if(homeG.equals("n")){
						hometeamGoals = 0;
					}else{
						hometeamGoals = Integer.parseInt(homeG);
					}

					start = s.indexOf("goalsAwayTeam") + 15;
					stop = s.indexOf("goalsAwayTeam") + 16;
					String awayG = s.substring(start, stop);
					int awayteamGoals;
					if(awayG.equals("n")){
						awayteamGoals = 0;
					}else{
						awayteamGoals = Integer.parseInt(awayG);
					}

					start = s.indexOf("status") + 10;
					stop = s.indexOf("matchday") - 4;
					String status = s.substring(start, stop);

					System.out.println(home + " " + away + " " + date + " " + matchDay + " " + hometeamGoals + " "
							+ awayteamGoals);
					Match match = new Match(home, away, date, matchDay, hometeamGoals, awayteamGoals, status);
					if(hometeamGoals>awayteamGoals){
						result.addBet("1");
					}else if(hometeamGoals<awayteamGoals){
						result.addBet("2");
					}else{
						result.addBet("X");
					}
					list.add(match);
					
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
