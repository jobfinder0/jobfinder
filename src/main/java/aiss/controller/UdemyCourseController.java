package aiss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.udemy.Result;
import aiss.resources.UdemyResource;

public class UdemyCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UdemyCourseController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String code = request.getParameter("code");
		String accessToken = request.getParameter("accessToken");
		RequestDispatcher rd = null;
		UdemyResource udemyResource = new UdemyResource();
		Result course = udemyResource.getCourse(code);
		request.setAttribute("accessToken", accessToken);
		if (course!=null){
			rd = request.getRequestDispatcher("/udemyCourse.jsp");
			request.setAttribute("course", course);			
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
