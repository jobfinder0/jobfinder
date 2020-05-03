package aiss.api.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.api.model.Comment;
import aiss.api.model.Course;


public class MapCourseRepository implements CourseRepository{

	Map<String, Course> courseMap;
	Map<String, Comment> commentMap;
	private static MapCourseRepository instance=null;
	private int indexCourses=0;			// Index to create courses identifiers.
	private int indexComment=0;			// Index to create comments identifiers.
	
	
	public static MapCourseRepository getInstance() {
		
		if (instance==null) {
			instance = new MapCourseRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		courseMap = new HashMap<String,Course>();
		commentMap = new HashMap<String,Comment>();
		
		// Create comments
		Comment comment1 = new Comment();
		comment1.setUsername("Usuario1");
		comment1.setText("Curso muy interesante.");
		addComment(comment1);
		
		Comment comment2 = new Comment();
		comment2.setUsername("Usuario2");
		comment2.setText("Un poco aburrido.");
		addComment(comment2);
		
		Comment comment3 = new Comment();
		comment3.setUsername("Usuario3");
		comment3.setText("Muy útil.");
		addComment(comment3);
		
		Comment comment4 = new Comment();
		comment4.setUsername("Usuario5");
		comment4.setText("Un poco aburrido.");
		addComment(comment4);
		
		Comment comment5 = new Comment();
		comment5.setUsername("Usuario1");
		comment5.setText("Interesante.");
		addComment(comment5);
		
		// Create courses
		Course courseComments =new Course();
		courseComments.setTitle("Curso de java");
		courseComments.setDescription("Aprende java rápido desde cero.");
		courseComments.setPrice(12.99);
		courseComments.setCurrency("EUR");
		addCourse(courseComments);
		
		Course courseNoComment=new Course();
		courseNoComment.setTitle("Curso de android");
		courseNoComment.setDescription("Master Desarrollo Android con Java y Kotlin");
		courseNoComment.setPrice(14.99);
		courseNoComment.setCurrency("EUR");
		addCourse(courseNoComment);
		
		Course courseOneComment = new Course();
		courseOneComment.setTitle("Curso de Android y Firebase avanzado ");
		courseOneComment.setDescription("Crea una App como UBER utilizando Android Studio y Firebase");
		courseOneComment.setPrice(0.0);
		courseOneComment.setCurrency("EUR");
		addCourse(courseOneComment);
		
		// Add comments to courses
		addComment(courseComments.getId(), comment1.getId());
		addComment(courseComments.getId(), comment2.getId());
		addComment(courseComments.getId(), comment3.getId());
		addComment(courseComments.getId(), comment4.getId());
		
		addComment(courseOneComment.getId(), comment5.getId());
	}
	
	// Course related operations
	@Override
	public void addCourse(Course c) {
		String id = "course" + indexCourses++;	
		c.setId(id);
		courseMap.put(id,c);
	}
	
	@Override
	public Collection<Course> getAllCourses() {
			return courseMap.values();
	}

	@Override
	public Course getCourse(String id) {
		return courseMap.get(id);
	}
	
	@Override
	public void updateCourse(Course c) {
		courseMap.put(c.getId(),c);
	}

	@Override
	public void deleteCourse(String id) {	
		courseMap.remove(id);
	}
	

	@Override
	public void addComment(String courseId, String commentId) {
		Course course = getCourse(courseId);
		course.addComment(commentMap.get(commentId));
	}

	@Override
	public Collection<Comment> getAll(String courseId) {
		return getCourse(courseId).getComments();
	}

	@Override
	public void removeComment(String courseId, String commentId) {
		getCourse(courseId).deleteComment(commentId);
	}

	
	// Comment related operations
	
	@Override
	public void addComment(Comment c) {
		String id = "comment" + indexComment++;
		c.setId(id);
		commentMap.put(id, c);
	}
	
	@Override
	public Collection<Comment> getAllComments() {
			return commentMap.values();
	}

	@Override
	public Comment getComment(String commentId) {
		return commentMap.get(commentId);
	}

	@Override
	public void updateComment(Comment c) {
		Comment comment = commentMap.get(c.getId());
		comment.setText(c.getText());
		comment.setUsername(c.getUsername());
	}

	@Override
	public void deleteComment(String commentId) {
		commentMap.remove(commentId);
	}
	
}
