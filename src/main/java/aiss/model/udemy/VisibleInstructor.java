package aiss.model.udemy;

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
"display_name",
"title",
"name",
"_class",
"job_title",
"image_50x50",
"initials",
"url",
"image_100x100"
})
public class VisibleInstructor {

@JsonProperty("display_name")
private String displayName;
@JsonProperty("title")
private String title;
@JsonProperty("name")
private String name;
@JsonProperty("_class")
private String _class;
@JsonProperty("job_title")
private String jobTitle;
@JsonProperty("image_50x50")
private String image50x50;
@JsonProperty("initials")
private String initials;
@JsonProperty("url")
private String url;
@JsonProperty("image_100x100")
private String image100x100;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("display_name")
public String getDisplayName() {
return displayName;
}

@JsonProperty("display_name")
public void setDisplayName(String displayName) {
this.displayName = displayName;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("_class")
public String getClass_() {
return _class;
}

@JsonProperty("_class")
public void setClass_(String _class) {
this._class = _class;
}

@JsonProperty("job_title")
public String getJobTitle() {
return jobTitle;
}

@JsonProperty("job_title")
public void setJobTitle(String jobTitle) {
this.jobTitle = jobTitle;
}

@JsonProperty("image_50x50")
public String getImage50x50() {
return image50x50;
}

@JsonProperty("image_50x50")
public void setImage50x50(String image50x50) {
this.image50x50 = image50x50;
}

@JsonProperty("initials")
public String getInitials() {
return initials;
}

@JsonProperty("initials")
public void setInitials(String initials) {
this.initials = initials;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("image_100x100")
public String getImage100x100() {
return image100x100;
}

@JsonProperty("image_100x100")
public void setImage100x100(String image100x100) {
this.image100x100 = image100x100;
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