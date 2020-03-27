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
        "carrier_moniker",
        "date",
        "date_with_derived_offset",
        "location",
        "status_code_mapping"
})
public class Event {

    @JsonProperty("carrier_moniker")
    private String carrierMoniker;
    @JsonProperty("date")
    private String date;
    @JsonProperty("date_with_derived_offset")
    private Object dateWithDerivedOffset;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("status_code_mapping")
    private StatusCodeMapping statusCodeMapping;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("carrier_moniker")
    public String getCarrierMoniker() {
        return carrierMoniker;
    }

    @JsonProperty("carrier_moniker")
    public void setCarrierMoniker(String carrierMoniker) {
        this.carrierMoniker = carrierMoniker;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_with_derived_offset")
    public Object getDateWithDerivedOffset() {
        return dateWithDerivedOffset;
    }

    @JsonProperty("date_with_derived_offset")
    public void setDateWithDerivedOffset(Object dateWithDerivedOffset) {
        this.dateWithDerivedOffset = dateWithDerivedOffset;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("status_code_mapping")
    public StatusCodeMapping getStatusCodeMapping() {
        return statusCodeMapping;
    }

    @JsonProperty("status_code_mapping")
    public void setStatusCodeMapping(StatusCodeMapping statusCodeMapping) {
        this.statusCodeMapping = statusCodeMapping;
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
