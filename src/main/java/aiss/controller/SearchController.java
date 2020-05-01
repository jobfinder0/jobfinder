package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.common.Course;
import aiss.resources.LinkedInResource;
import aiss.resources.TutellusResource;
import aiss.resources.UdemyResource;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<Course> courses = new ArrayList<Course>();
		String searchQuery = request.getParameter("searchQuery");
		if(searchQuery==null) {
			searchQuery="";
		}
		String accessToken = "";
		LinkedInResource linkResource = new LinkedInResource();
		if(request.getParameter("accessToken")==null) {
			 accessToken = linkResource.getAccessToken(request.getParameter("code")).getAccessToken();
		}else {
			accessToken = request.getParameter("accessToken");
		}
		RequestDispatcher rd = null;
		log.log(Level.FINE, "Searching for Tutellus courses that contain " + searchQuery);
		TutellusResource tutellusResource = new TutellusResource();
		List<Course> coursesTutellus = tutellusResource.getCourses(searchQuery);
		log.log(Level.FINE, "Searching for Udemy courses that contain " + searchQuery);
		UdemyResource udemyResource = new UdemyResource();
		List<Course> coursesUdemy = udemyResource.getCourses(searchQuery);
		request.setAttribute("accessToken", accessToken);
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
		Boolean notResult = courses.isEmpty();
		request.setAttribute("notResult", notResult);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
