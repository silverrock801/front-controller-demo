package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
 * This method will be responsible to determining what resource the client is requesting
 * It will clean the URL and only capture the end part
 * 
 * Once it captures the destination, it calls a RequestHelper which will supply the right functionality.
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. Save the URI and rewrite it
		final String URI = request.getRequestURI().replace("/FrontControllerDemo/", "");//This will leave nothing but the end part (login)
		
		//2. Make a switch case statement and call the appropriate functionality based on the URI return
		switch(URI) {
		case "login":
			//call the login method and pass the request and response object
			RequestHelper.processLogin(request, response);
			break;
		case "error":
			//Call some method that processes a 404 error
			RequestHelper.processError(request, response);
			break;
		case "employees":
			//This method will return all users from DB to the client
			RequestHelper.processEmployees(request, response);
			break;
		default:
			//Call some method that processes a 404 error
			RequestHelper.processError(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// If a client sends a POST request here, it invokes doGET() instead
		doGet(request, response);
	}

}
