package aiss.api.model.repository;

import java.util.Collection;

import aiss.api.model.Comment;
import aiss.api.model.Course;


public interface CourseRepository {
	
	
	// Comments
	public void addComment(Comment c);
	public Collection<Comment> getAllComments();
	public Comment getComment(String commentId);
	public void updateComment(Comment c);
	public void deleteComment(String commentId);
	
	// Courses
	public void addCourse(Course c);
	public Collection<Course> getAllCourses();
	public Course getCourse(String courseId);
	public void updateCourse(Course c);
	public void deleteCourse(String courseId);
	public Collection<Comment> getAll(String courseId);
	public void addComment(String courseId, String commentId);
	public void removeComment(String courseId, String commentId); 

	
	
	
	

}
