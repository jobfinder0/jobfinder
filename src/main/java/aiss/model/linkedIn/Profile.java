package aiss.model.linkedIn;
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
"firstName",
"localizedFirstName",
"headline",
"localizedHeadline",
"vanityName",
"id",
"lastName",
"localizedLastName",
"profilePicture"
})
public class Profile {

@JsonProperty("firstName")
private FirstName firstName;
@JsonProperty("localizedFirstName")
private String localizedFirstName;
@JsonProperty("headline")
private HeadLine headline;
@JsonProperty("localizedHeadline")
private String localizedHeadline;
@JsonProperty("vanityName")
private String vanityName;
@JsonProperty("id")
private String id;
@JsonProperty("lastName")
private LastName lastName;
@JsonProperty("localizedLastName")
private String localizedLastName;
@JsonProperty("profilePicture")
private ProfilePicture profilePicture;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("firstName")
public FirstName getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(FirstName firstName) {
this.firstName = firstName;
}

@JsonProperty("localizedFirstName")
public String getLocalizedFirstName() {
return localizedFirstName;
}

@JsonProperty("localizedFirstName")
public void setLocalizedFirstName(String localizedFirstName) {
this.localizedFirstName = localizedFirstName;
}

@JsonProperty("headline")
public HeadLine getHeadline() {
return headline;
}

@JsonProperty("headline")
public void setHeadline(HeadLine headline) {
this.headline = headline;
}

@JsonProperty("localizedHeadline")
public String getLocalizedHeadline() {
return localizedHeadline;
}

@JsonProperty("localizedHeadline")
public void setLocalizedHeadline(String localizedHeadline) {
this.localizedHeadline = localizedHeadline;
}

@JsonProperty("vanityName")
public String getVanityName() {
return vanityName;
}

@JsonProperty("vanityName")
public void setVanityName(String vanityName) {
this.vanityName = vanityName;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("lastName")
public LastName getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(LastName lastName) {
this.lastName = lastName;
}

@JsonProperty("localizedLastName")
public String getLocalizedLastName() {
return localizedLastName;
}

@JsonProperty("localizedLastName")
public void setLocalizedLastName(String localizedLastName) {
this.localizedLastName = localizedLastName;
}

@JsonProperty("profilePicture")
public ProfilePicture getProfilePicture() {
return profilePicture;
}

@JsonProperty("profilePicture")
public void setProfilePicture(ProfilePicture profilePicture) {
this.profilePicture = profilePicture;
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