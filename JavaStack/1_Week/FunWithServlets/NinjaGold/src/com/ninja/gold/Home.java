package com.ninja.gold;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String GOLD_KEY = "totalGold";
	private String MESSAGES_KEY = "messages";
	
	private int processGold(String building) {
		Random r = new Random();
		int lower;
		int upper;
		switch(building) {
		case "farm":
			// 2 - 5
			upper = 5;
			lower = 2;
			return r.nextInt(upper - lower) + lower;
		case "house":
			upper = 7;
			lower = 3;
			return r.nextInt(upper - lower) + lower;
		case "cave":
			upper = 9;
			lower = 7;
			return r.nextInt(upper - lower) + lower;
		default:
			upper = 50;
			lower = 10;
			int result = r.nextInt(upper - lower) + lower;
			if(r.nextInt(2) == 1)
				result = result * -1;
			return result;
		}
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// First Time User Experience
		// is there a value of "totalGold" in session?
		request.setAttribute("message", "");

		HttpSession session = request.getSession();
		// session["totalGold"]
		Object gold = session.getAttribute(GOLD_KEY);
		if(gold == null) {
			session.setAttribute(GOLD_KEY, 0);
		}
		Object messages = session.getAttribute(MESSAGES_KEY);
		if(messages == null) {
			session.setAttribute(MESSAGES_KEY, new ArrayList<String>());
		}
		
		// passing data to jsp
		request.setAttribute("gold", session.getAttribute(GOLD_KEY));
		request.setAttribute("messages", (ArrayList<String>)session.getAttribute(MESSAGES_KEY));
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String building = request.getParameter("building");
		System.out.println(String.format("%s is the building", building));
		
		// get current gold in session
		int sessionGold = (int)session.getAttribute(GOLD_KEY);
		
		// increment that by the amount per building
		int currGold = this.processGold(building);
		sessionGold += currGold;
		// for now let's increment by 5
		
		// reset session value
		session.setAttribute(GOLD_KEY, sessionGold);
		
		
		String message = String.format("You got %d of gold from the %s", currGold, building);
		ArrayList<String> messages = (ArrayList<String>)session.getAttribute(MESSAGES_KEY);
		messages.add(message);
		session.setAttribute(MESSAGES_KEY, messages);
		
		response.sendRedirect("/NinjaGold/Home");
	}

}
