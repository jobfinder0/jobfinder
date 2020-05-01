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
"currency",
"amount",
"price_string",
"currency_symbol"
})
public class PriceDetail {

@JsonProperty("currency")
private String currency;
@JsonProperty("amount")
private Double amount;
@JsonProperty("price_string")
private String priceString;
@JsonProperty("currency_symbol")
private String currencySymbol;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("currency")
public String getCurrency() {
return currency;
}

@JsonProperty("currency")
public void setCurrency(String currency) {
this.currency = currency;
}

@JsonProperty("amount")
public Double getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Double amount) {
this.amount = amount;
}

@JsonProperty("price_string")
public String getPriceString() {
return priceString;
}

@JsonProperty("price_string")
public void setPriceString(String priceString) {
this.priceString = priceString;
}

@JsonProperty("currency_symbol")
public String getCurrencySymbol() {
return currencySymbol;
}

@JsonProperty("currency_symbol")
public void setCurrencySymbol(String currencySymbol) {
this.currencySymbol = currencySymbol;
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