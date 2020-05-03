package aiss.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.JsonSyntaxException;

import aiss.model.common.CourseCommon;
import aiss.model.udemy.Courses;
import aiss.model.udemy.Result;


public class UdemyResource {
	String authorization = "Basic Sk94ekhEN0czSlNvalJXZ1V6RnRRZm82TE40QTM2QW55akRXcTNlODowYmNiNkoxZjRWTUNMSXZRN3lHWUJ0VUlUbzN2UHRUdGptMzczSHJBS2JqaUNJY1NqckpZVDVwODZuSTNlSG4zQkxveHNwSkI3eXdvc3N0SU53R1d0dzB2OExVNXI1U0VJek5VVUo0QmpvTU9qczBiZ0V0TTRlYmV5QTNjRHFjTw==";
	
	public List<CourseCommon> getCourses(String search) throws JsonSyntaxException, ClientProtocolException, IOException{
		List<CourseCommon> courses = new ArrayList<CourseCommon>();
		String query = "https://www.udemy.com/api-2.0/courses/?search="+search
				+ "&page_size=100";
         Gson gson = new Gson();
         Courses result =  gson.fromJson(getJson(query), Courses.class);
         
		List<Result> udemyResults = result.getResults();
		for (Result udemyResult : udemyResults) {
			CourseCommon course = new CourseCommon();
			course.setCode(udemyResult.getId().toString());
			course.setTitle(udemyResult.getTitle());
			char[] precio = udemyResult.getPrice().toCharArray();
			String n = "";
			boolean valid = false;
			for(int i =0;i<precio.length;i++) {
				if(Character.isDigit(precio[i])) {
					valid=true;
				}
				if(valid)
					n+=precio[i];
			}
			course.setPrice(Double.valueOf(n));
			course.setSummary(udemyResult.getHeadline());
			course.setType("udemy");
			courses.add(course);
		}

        return courses;
    }
	
	public Result getCourse(String code) throws JsonSyntaxException, ClientProtocolException, IOException {
		String query = "https://www.udemy.com/api-2.0/courses/"+code;
		 Gson gson = new Gson();
		 Result result =  gson.fromJson(getJson(query), Result.class);
		 result.setImage240x135(getImage(code));
        return result;
    }
	
	public String getJson(String url) throws ClientProtocolException, IOException {
	    DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader(HttpHeaders.AUTHORIZATION, authorization);
		org.apache.http.HttpResponse response;
        response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String json = EntityUtils.toString(entity);
        return json;
	}
	
		public String getImage(String code) throws JsonSyntaxException, ClientProtocolException, IOException {
		String query = "https://www.udemy.com/api-2.0/courses/"+code+"?fields[course]=image_240x135";
		String json = getJson(query);
		String[] jsonSplit =json.split(",");
		String[] url=jsonSplit[2].split(":");
		String res = url[1].concat(":").concat(url[2]).replaceAll("\"", "").replace("}", "");
        return res;
    }	
}
