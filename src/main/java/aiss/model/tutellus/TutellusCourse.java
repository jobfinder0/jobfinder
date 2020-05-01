package aiss.model.tutellus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"code",
"name",
"summary",
"description",
"image_url",
"video_url",
"url",
"difficulty_level",
"actived_on",
"category",
"subcategory",
"teacher",
"organization",
"price",
"stats",
"sections"
})
public class TutellusCourse {

@JsonProperty("code")
private String code;
@JsonProperty("name")
private String name;
@JsonProperty("summary")
private String summary;
@JsonProperty("description")
private String description;
@JsonProperty("image_url")
private String imageUrl;
@JsonProperty("video_url")
private String videoUrl;
@JsonProperty("url")
private String url;
@JsonProperty("difficulty_level")
private String difficultyLevel;
@JsonProperty("actived_on")
private String activedOn;
@JsonProperty("category")
private Category category;
@JsonProperty("subcategory")
private Subcategory subcategory;
@JsonProperty("teacher")
private Teacher teacher;
@JsonProperty("organization")
private Organization organization;
@JsonProperty("price")
private Price price;
@JsonProperty("stats")
private Stats stats;
@JsonProperty("sections")
private List<Section> sections = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("code")
public String getCode() {
return code;
}

@JsonProperty("code")
public void setCode(String code) {
this.code = code;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("summary")
public String getSummary() {
return summary;
}

@JsonProperty("summary")
public void setSummary(String summary) {
this.summary = summary;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("image_url")
public String getImageUrl() {
return imageUrl;
}

@JsonProperty("image_url")
public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

@JsonProperty("video_url")
public String getVideoUrl() {
return videoUrl;
}

@JsonProperty("video_url")
public void setVideoUrl(String videoUrl) {
this.videoUrl = videoUrl;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("difficulty_level")
public String getDifficultyLevel() {
return difficultyLevel;
}

@JsonProperty("difficulty_level")
public void setDifficultyLevel(String difficultyLevel) {
this.difficultyLevel = difficultyLevel;
}

@JsonProperty("actived_on")
public String getActivedOn() {
return activedOn;
}

@JsonProperty("actived_on")
public void setActivedOn(String activedOn) {
this.activedOn = activedOn;
}

@JsonProperty("category")
public Category getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(Category category) {
this.category = category;
}

@JsonProperty("subcategory")
public Subcategory getSubcategory() {
return subcategory;
}

@JsonProperty("subcategory")
public void setSubcategory(Subcategory subcategory) {
this.subcategory = subcategory;
}

@JsonProperty("teacher")
public Teacher getTeacher() {
return teacher;
}

@JsonProperty("teacher")
public void setTeacher(Teacher teacher) {
this.teacher = teacher;
}

@JsonProperty("organization")
public Organization getOrganization() {
return organization;
}

@JsonProperty("organization")
public void setOrganization(Organization organization) {
this.organization = organization;
}

@JsonProperty("price")
public Price getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(Price price) {
this.price = price;
}

@JsonProperty("stats")
public Stats getStats() {
return stats;
}

@JsonProperty("stats")
public void setStats(Stats stats) {
this.stats = stats;
}

@JsonProperty("sections")
public List<Section> getSections() {
return sections;
}

@JsonProperty("sections")
public void setSections(List<Section> sections) {
this.sections = sections;
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