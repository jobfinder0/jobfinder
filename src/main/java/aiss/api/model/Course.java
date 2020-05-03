package aiss.api.model;

import java.util.ArrayList;
import java.util.List;


public class Course {
	private String id;
	private String title;
	private String description;
	private Double price;
	private String currency;
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	private List<Comment> comments;
	
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}
	
	protected void setComments(List<Comment> s) {
		comments = s;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public Comment getComment(String id) {
		if (comments==null)
			return null;
		
		Comment comment =null;
		for(Comment s: comments)
			if (s.getId().equals(id))
			{
				comment=s;
				break;
			}
		
		return comment;
	}
	
	public void addComment(Comment s) {
		if (comments==null)
			comments = new ArrayList<Comment>();
		comments.add(s);
	}
	
	public void deleteComment(Comment s) {
		comments.remove(s);
	}
	
	public void deleteComment(String id) {
		Comment s = getComment(id);
		if (s!=null)
			comments.remove(s);
	}

}
