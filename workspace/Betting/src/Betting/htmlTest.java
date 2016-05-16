package Betting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.ContextConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class htmlTest extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		File input = new File("C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\homepage.html");
		Document doc = Jsoup.parse(input,null);
        //Element E = doc.select("div").first();
		 Element content = doc.getElementById("date");
		 content.text("kalas");
		 //System.out.print(content.html()); 
		 BufferedWriter bw = new BufferedWriter(new FileWriter(input));
		  bw.write(doc.html());
		  bw.close();
		  // content.html("new date");
//		 BufferedReader reader = new BufferedReader(new StringReader(content.toString()));
//		 String line;
//		 while ((line = reader.readLine()) != null){
//			 if (line.contains("PREMIER LEAGUE")){
//				 System.out.println(reader.readLine());
//			 }
//		 };
      PrintWriter output = resp.getWriter();
      output.write(doc.html());
      output.close();
	}
}
