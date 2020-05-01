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
"localized",
"preferredLocale"
})
public class LastName {

@JsonProperty("localized")
private Localized localized;
@JsonProperty("preferredLocale")
private PreferredLocale preferredLocale;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("localized")
public Localized getLocalized() {
return localized;
}

@JsonProperty("localized")
public void setLocalized(Localized localized) {
this.localized = localized;
}

@JsonProperty("preferredLocale")
public PreferredLocale getPreferredLocale() {
return preferredLocale;
}

@JsonProperty("preferredLocale")
public void setPreferredLocale(PreferredLocale preferredLocale) {
this.preferredLocale = preferredLocale;
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