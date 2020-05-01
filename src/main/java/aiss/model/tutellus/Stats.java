package aiss.model.tutellus;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"reviews_avg",
"duration",
"students",
"reviews"
})
public class Stats {

@JsonProperty("reviews_avg")
private Object reviewsAvg;
@JsonProperty("duration")
private Integer duration;
@JsonProperty("students")
private Integer students;
@JsonProperty("reviews")
private Integer reviews;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("reviews_avg")
public Object getReviewsAvg() {
return reviewsAvg;
}

@JsonProperty("reviews_avg")
public void setReviewsAvg(Object reviewsAvg) {
this.reviewsAvg = reviewsAvg;
}

@JsonProperty("duration")
public Integer getDuration() {
return duration;
}

@JsonProperty("duration")
public void setDuration(Integer duration) {
this.duration = duration;
}

@JsonProperty("students")
public Integer getStudents() {
return students;
}

@JsonProperty("students")
public void setStudents(Integer students) {
this.students = students;
}

@JsonProperty("reviews")
public Integer getReviews() {
return reviews;
}

@JsonProperty("reviews")
public void setReviews(Integer reviews) {
this.reviews = reviews;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}