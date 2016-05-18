package MatchPack;

public class Match {
	private String homeTeam, awayTeam, date;
	private int homeGoals, awayGoals, matchDay;
	private boolean status;
	
	public Match(String homeTeam, String awayTeam, String date, int matchDay){
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date; 
		this.matchDay = matchDay;
	}
	public Match (String homeTeam, String awayTeam, String date, int matchDay, int homeGoals, int awayGoals){
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date; 
		this.matchDay = matchDay;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}
	
	public String getHomeTeam(){
		return homeTeam;
	}
	public String getAwayTeam(){
		return awayTeam;
	}
	public String getDate(){
		return date;
	}
	public int getMatchDay(){
		return matchDay;
	}
	public int getHomeGoals(){
		return homeGoals;
	}
	public int getAwayGoals(){
		return awayGoals;
	}
	public boolean getStatus(){
		return status;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public boolean equals(Match m){
		if(m.getHomeTeam().equals(getHomeTeam()) && m.getAwayTeam().equals(getAwayTeam())
				&& m.getDate().equals(getDate())){
			return true;
		}
		return false;
	}
}
