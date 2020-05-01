package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.common.Course;
import aiss.resources.LinkedInResource;
import aiss.resources.TutellusResource;
import aiss.resources.UdemyResource;

public class UgcPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UgcPostController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String shareCommentary = request.getParameter("shareCommentary");
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String web = request.getParameter("web");
		String accessToken = request.getParameter("accessToken");
		LinkedInResource linkResource = new LinkedInResource();
		linkResource.ugcPost(shareCommentary, title, url, web, accessToken);
		RequestDispatcher rd = null;
		request.setAttribute("accessToken", accessToken);
		List<Course> courses = new ArrayList<Course>();
		String searchQuery = "";
		TutellusResource tutellusResource = new TutellusResource();
		List<Course> coursesTutellus = tutellusResource.getCourses(searchQuery);
		UdemyResource udemyResource = new UdemyResource();
		List<Course> coursesUdemy = udemyResource.getCourses(searchQuery);
		if (coursesTutellus!=null){
			courses.addAll(coursesTutellus);
		}
		if(coursesUdemy!=null) {
			courses.addAll(coursesUdemy);
		}
		Collections.sort(courses, new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				if (c1.getPrice() < c2.getPrice()) {
		              return -1;
		          }
		          if (c1.getPrice() > c2.getPrice()) {
		              return 1;
		          }
		          return 0;
			}
		});
		rd = request.getRequestDispatcher("/courses.jsp");
		request.setAttribute("courses", courses);	
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
