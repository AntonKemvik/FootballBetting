package Betting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class loginTest extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] User = req.getParameterValues("username");
		String[] Pass = req.getParameterValues("password");
		for (String s : User) {
			System.out.print(s);
		}
		for (String s : Pass) {
			System.out.print(s);
		}
		if (User[0].equals("nils")) {
			File input = new File(
					"C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\homepage.html");
			Document doc = Jsoup.parse(input, null);
		    Element content = doc.getElementById("match1");
		    for (int i=0;i<4;i++){
		    content.child(i).text("hej" + i);
		    }
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
		} else {
			File input = new File(
					"C:\\Users\\Stoffe\\workspace\\Betting\\WebContent\\login.html");
			Document doc = Jsoup.parse(input, null);
			// Element E = doc.select("div").first();
			Element content = doc.getElementById("normalText");
			content.html("Wrong username");
			PrintWriter output = resp.getWriter();
			output.write(doc.html());
			output.close();
			// PrintWriter output = resp.getWriter();
			// output.write(doc.html());
			// output.close();
		}
	}
}
