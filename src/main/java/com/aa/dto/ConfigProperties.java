
package com.aa.dto;

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
    "name",
    "profiles",
    "label",
    "version",
    "state",
    "propertySources"
})
public class ConfigProperties {

    @JsonProperty("name")
    private String name;
    @JsonProperty("profiles")
    private List<String> profiles = null;
    @JsonProperty("label")
    private Object label;
    @JsonProperty("version")
    private Object version;
    @JsonProperty("state")
    private Object state;
    @JsonProperty("propertySources")
    private List<PropertySource> propertySources = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("profiles")
    public List<String> getProfiles() {
        return profiles;
    }

    @JsonProperty("profiles")
    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }

    @JsonProperty("label")
    public Object getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(Object label) {
        this.label = label;
    }

    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonProperty("state")
    public Object getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(Object state) {
        this.state = state;
    }

    @JsonProperty("propertySources")
    public List<PropertySource> getPropertySources() {
        return propertySources;
    }

    @JsonProperty("propertySources")
    public void setPropertySources(List<PropertySource> propertySources) {
        this.propertySources = propertySources;
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
