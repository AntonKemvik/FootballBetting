package Betting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class responseTest extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
      String[] User = req.getParameterValues("username");
      String[] Pass = req.getParameterValues("password");
      for (String s:User){
    	  System.out.print(s);
      }
      for (String s:Pass){
    	  System.out.print(s);
      }
      resp.sendRedirect(("http://localhost:8080/Betting/homepage.html"));
	}
}
