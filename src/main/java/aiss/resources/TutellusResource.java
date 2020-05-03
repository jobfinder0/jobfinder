package aiss.resources;

import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.ClientResource;

import aiss.model.common.CourseCommon;
import aiss.model.tutellus.TutellusCourse;

public class TutellusResource {
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJOZUxQT2JWNTNhIiwiYXVkIjoiYWZmaWxpYXRlIiwiYWZmX3Rva2VuIjoiOGJiOGNiYzU0OTYwNGNiMTk1ZTQ0NTY0Y2RkOTFjYjIiLCJpYXQiOjE1ODgyODQ3MzJ9.VJn7Lsm23C5nP5YqR6a_7ERF-RAXZJY3hLVz44uYLQs";
	
	public List<CourseCommon> getCourses(String search) {
		List<CourseCommon> courses = new ArrayList<CourseCommon>();
		String query = "https://affiliate.tutellus.com/api/v1/courses?q="+search
				+ "&limit=100";
		//head-> x-access-token : token
		ClientResource cr = new ClientResource(query);
		cr.getRequest().getHeaders().set("x-access-token", token);
		TutellusCourse[] results = cr.get(TutellusCourse[].class);
		for (TutellusCourse result : results) {
			CourseCommon course = new CourseCommon();
			course.setCode(result.getCode());
			course.setTitle(result.getName());
			course.setPrice(result.getPrice().getEUR().doubleValue());
			course.setSummary(result.getSummary());
			course.setType("tutellus");
			courses.add(course);
		}
        return courses;
    }
	public TutellusCourse getCourse(String code) {
		String query = "https://affiliate.tutellus.com/api/v1/courses/"+code;
		ClientResource cr = new ClientResource(query);
		cr.getRequest().getHeaders().set("x-access-token", token);
		TutellusCourse result = cr.get(TutellusCourse.class);
        return result;
    }
	
}
