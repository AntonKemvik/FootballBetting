package MatchPack;
import java.util.ArrayList;

public class AllBets {
	private ArrayList<Bet> bets;

	public AllBets() {
		bets = new ArrayList<Bet>();
	}
	public void addBet(Bet b){
		bets.add(b);
	}
	public ArrayList<Bet> getAllBets(){
		return bets;
	}
	public ArrayList<Bet> getAllBetsFromPlayer(Player p){
		ArrayList<Bet> temp = new ArrayList<Bet>();
		for(Bet b : bets){
			if(b.getPlayer().equals(p)){
				temp.add(b);
			}
		}
		return temp;
	}

}
