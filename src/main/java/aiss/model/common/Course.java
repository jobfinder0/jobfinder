package aiss.model.common;

public class Course implements Comparable<Course>{
	String title;
	Double price;
	String summary;
	String code;
	String type;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	  @Override
      public int compareTo(Course c) {
          if (price < c.price) {
              return -1;
          }
          if (price > c.price) {
              return 1;
          }
          return 0;
      }
}
