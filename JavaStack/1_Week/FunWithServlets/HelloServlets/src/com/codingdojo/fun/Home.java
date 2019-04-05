package com.codingdojo.fun;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// "pizza"
		String height = request.getParameter("height");
		String width = request.getParameter("width");
		int intHeight;
		int intWidth;
		try {
			// make sure we can convert string to int
			intHeight = Integer.parseInt(height);	
		} catch (NumberFormatException e) {
			System.out.println(e);
			intHeight = 5;
		}
		try {
			intWidth = Integer.parseInt(width);
		} catch (NumberFormatException e) {
			System.out.println(e);
			intWidth = 5;
		}
		
		Gorilla g = new Gorilla("Harris", "Henderson", "Hawkeye");
		
		request.setAttribute("height", intHeight);
		request.setAttribute("width", intWidth);
		request.setAttribute("gorilla", g);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
