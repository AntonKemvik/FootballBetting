package MatchPack;
import java.util.ArrayList;
import java.util.Calendar;

public class Fixtures {
	ArrayList<Match> matches;
	Calendar cal;
	StringBuilder sb;

	public Fixtures() {
		cal = Calendar.getInstance();
	}

	public void addMatch(Match mat) {
		matches.add(mat);
	}

	public void removeMatch(Match mat) {
		matches.remove(mat);
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
}
