package com.kh.test.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		int black = Integer.parseInt(req.getParameter("blackPen"));
		int red = Integer.parseInt(req.getParameter("redPen"));
		int blue = Integer.parseInt(req.getParameter("bluePen"));
		int white = Integer.parseInt(req.getParameter("white"));
		
		int total = black*500 + red*700 + blue*700 + white*1000;
		
		if(total>0) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
			
			req.setAttribute("name", name);
			req.setAttribute("blackPen", black); 
			req.setAttribute("redPen", red); 
			req.setAttribute("bluePen", blue); 
			req.setAttribute("white", white); 
			req.setAttribute("total", total); 
			
			dispatcher.forward(req, resp);
		}
		if(total ==0) resp.sendRedirect("/error");

	}
	
	public class Library{
		private Book book;
		public Library() {
			this.book = new Book();
		}
	}
	public class Book{
		private String title;
		private String author;
	}
	
	
}
