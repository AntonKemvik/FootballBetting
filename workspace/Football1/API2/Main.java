package API2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

	public static void main(String[] args) throws IOException {
		URL test = new URL("http://api.football-data.org/v1/soccerseasons/400/fixtures?matchday=36");
		URLConnection myUrlCon = test.openConnection();
		myUrlCon.addRequestProperty("X-Auth-Token", "8694272ad6134ac2995601c6a46c1f68");
		InputStream is = myUrlCon.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		System.out.println(br.readLine());
		
		AfterMatchCompiler ls = new AfterMatchCompiler();
		ls.run(test);
		
			
			
//			System.out.println(list.get(0));
			
			
//			Runner[] runners = new Runner[10];

//			for (int i = 0; i < 10; i++) {
//
//				runners[i] = new Runner(list);
//				runners[i].start();
//
//			}

	}
	}


