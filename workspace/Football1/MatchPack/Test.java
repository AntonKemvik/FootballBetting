package MatchPack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static void main(String[] args) throws IOException {
		URL test = new URL("http://api.football-data.org/v1/soccerseasons/398/fixtures?matchday=35");
		URLConnection myUrlCon = test.openConnection();
		myUrlCon.addRequestProperty("X-Auth-Token", "8694272ad6134ac2995601c6a46c1f68");
		InputStream is = myUrlCon.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());

		Player p1 = new Player("Isak");
		Player p2 = new Player("Nils");
		Player p3 = new Player("Anton");
		Player p4 = new Player("Kringlan");
		AllPlayers players = new AllPlayers();

		players.addPlayer(p2);
		players.addPlayer(p4);
		players.addPlayer(p3);
		players.addPlayer(p1);

		p1.addPoint();
		p1.addPoint();
		p1.addPoint();
		p1.addPoint();
		p2.addPoint();
		p2.addPoint();
		p2.addPoint();
		p3.addPoint();
		p3.addPoint();
		p4.addPoint();
		for (Player p : players.getScoreboard()) {
			System.out.println(p.getName() + " " + p.getPoints());
		}
		for ( Player p : players.getAllPlayers()){
			System.out.println(p.getName() + p.getPoints());
		}
		players.saveToFile();
	}
}
