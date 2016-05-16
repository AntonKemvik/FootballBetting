package MatchPack;

public class Bet {
	private Player p;
	private Match m;
	private String placedBet;

	public Bet(Player p, Match m, String placedBet) {
		this.p = p;
		this.m = m;
		this.placedBet = placedBet;
	}

	public Player getPlayer() {
		return p;
	}
	public Match getMatch(){
		return m;
	}
	public String getPlacedBet(){
		return placedBet;
	}

}
