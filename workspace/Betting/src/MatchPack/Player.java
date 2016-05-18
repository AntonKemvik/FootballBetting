package MatchPack;

public class Player {
	private String name;
	private int points;

	public Player(String name) {
		this.name = name;
		points = 0;

	}

	public Player(String name, int points) {
		this.name = name;
		this.points = points;

	}

	public void addPoint() {
		points++;

	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Player p) {
		if (getName().equals(p.getName())) {
			return true;
		}
		return false;
	}
}
