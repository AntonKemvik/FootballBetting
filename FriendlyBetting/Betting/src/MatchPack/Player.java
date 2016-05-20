package MatchPack;

public class Player {
	private String name, password;
	private int points;

	public Player(String name, String password, int points) {
		this.name = name;
		this.points = points;
		this.password = password;

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

	public String getPassword() {
		return password;
	}
}
