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
"CRC",
"PEN",
"DOP",
"HNL",
"BOB",
"MXN",
"USD",
"GTQ",
"NIO",
"CUP",
"PYG",
"ARS",
"CLP",
"PAB",
"VEF",
"COP",
"UYU",
"EUR"
})
public class Price {

@JsonProperty("CRC")
private Integer cRC;
@JsonProperty("PEN")
private Integer pEN;
@JsonProperty("DOP")
private Integer dOP;
@JsonProperty("HNL")
private Integer hNL;
@JsonProperty("BOB")
private Integer bOB;
@JsonProperty("MXN")
private Integer mXN;
@JsonProperty("USD")
private Integer uSD;
@JsonProperty("GTQ")
private Integer gTQ;
@JsonProperty("NIO")
private Integer nIO;
@JsonProperty("CUP")
private Integer cUP;
@JsonProperty("PYG")
private Integer pYG;
@JsonProperty("ARS")
private Integer aRS;
@JsonProperty("CLP")
private Integer cLP;
@JsonProperty("PAB")
private Integer pAB;
@JsonProperty("VEF")
private Integer vEF;
@JsonProperty("COP")
private Integer cOP;
@JsonProperty("UYU")
private Integer uYU;
@JsonProperty("EUR")
private Integer eUR;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("CRC")
public Integer getCRC() {
return cRC;
}

@JsonProperty("CRC")
public void setCRC(Integer cRC) {
this.cRC = cRC;
}

@JsonProperty("PEN")
public Integer getPEN() {
return pEN;
}

@JsonProperty("PEN")
public void setPEN(Integer pEN) {
this.pEN = pEN;
}

@JsonProperty("DOP")
public Integer getDOP() {
return dOP;
}

@JsonProperty("DOP")
public void setDOP(Integer dOP) {
this.dOP = dOP;
}

@JsonProperty("HNL")
public Integer getHNL() {
return hNL;
}

@JsonProperty("HNL")
public void setHNL(Integer hNL) {
this.hNL = hNL;
}

@JsonProperty("BOB")
public Integer getBOB() {
return bOB;
}

@JsonProperty("BOB")
public void setBOB(Integer bOB) {
this.bOB = bOB;
}

@JsonProperty("MXN")
public Integer getMXN() {
return mXN;
}

@JsonProperty("MXN")
public void setMXN(Integer mXN) {
this.mXN = mXN;
}

@JsonProperty("USD")
public Integer getUSD() {
return uSD;
}

@JsonProperty("USD")
public void setUSD(Integer uSD) {
this.uSD = uSD;
}

@JsonProperty("GTQ")
public Integer getGTQ() {
return gTQ;
}

@JsonProperty("GTQ")
public void setGTQ(Integer gTQ) {
this.gTQ = gTQ;
}

@JsonProperty("NIO")
public Integer getNIO() {
return nIO;
}

@JsonProperty("NIO")
public void setNIO(Integer nIO) {
this.nIO = nIO;
}

@JsonProperty("CUP")
public Integer getCUP() {
return cUP;
}

@JsonProperty("CUP")
public void setCUP(Integer cUP) {
this.cUP = cUP;
}

@JsonProperty("PYG")
public Integer getPYG() {
return pYG;
}

@JsonProperty("PYG")
public void setPYG(Integer pYG) {
this.pYG = pYG;
}

@JsonProperty("ARS")
public Integer getARS() {
return aRS;
}

@JsonProperty("ARS")
public void setARS(Integer aRS) {
this.aRS = aRS;
}

@JsonProperty("CLP")
public Integer getCLP() {
return cLP;
}

@JsonProperty("CLP")
public void setCLP(Integer cLP) {
this.cLP = cLP;
}

@JsonProperty("PAB")
public Integer getPAB() {
return pAB;
}

@JsonProperty("PAB")
public void setPAB(Integer pAB) {
this.pAB = pAB;
}

@JsonProperty("VEF")
public Integer getVEF() {
return vEF;
}

@JsonProperty("VEF")
public void setVEF(Integer vEF) {
this.vEF = vEF;
}

@JsonProperty("COP")
public Integer getCOP() {
return cOP;
}

@JsonProperty("COP")
public void setCOP(Integer cOP) {
this.cOP = cOP;
}

@JsonProperty("UYU")
public Integer getUYU() {
return uYU;
}

@JsonProperty("UYU")
public void setUYU(Integer uYU) {
this.uYU = uYU;
}

@JsonProperty("EUR")
public Integer getEUR() {
return eUR;
}

@JsonProperty("EUR")
public void setEUR(Integer eUR) {
this.eUR = eUR;
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