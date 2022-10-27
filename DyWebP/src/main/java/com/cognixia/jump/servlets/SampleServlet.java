package com.cognixia.jump.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String message;
       
    
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//This method handles any initializations, in this case we set up the value of our message
	public void init(ServletConfig config) throws ServletException {
		message = "Hello World";
		
		System.out.println("Setting message as " + message);
	}

	// Get method that will be called by service() method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	// What will be called when servlet unloaded by container
	// stop tomcat server so that this can be called and printed to console
	public void destroy() {
		System.out.println("Finished using servlet, now being destroyed.");
	}
}
