package Betting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayerCreation extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] User = req.getParameterValues("cUsername");
		String[] Pass = req.getParameterValues("cPassword");
		String[] Address = req.getParameterValues("cEmailaddress");
		
	}
}
