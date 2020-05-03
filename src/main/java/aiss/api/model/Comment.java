package aiss.api.model;

public class Comment {
	
	private String id;
	private String text;
	private String username;

	public Comment() {
	}

	public Comment(String text, String username) {
		this.text = text;
		this.username = username;
	}
	
	public Comment(String id, String text, String username) {
		this.id = id;
		this.text = text;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
