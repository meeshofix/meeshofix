


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
        "tracking_number",
        "carrier_moniker",
        "origin",
        "dest",
        "estimated_delivery_date",
        "edd_source",
        "guaranteed_delivery_date",
        "service_code",
        "service_description",
        "events"
})
public class Tracking {

    @JsonProperty("tracking_number")
    private String trackingNumber;
    @JsonProperty("carrier_moniker")
    private String carrierMoniker;
    @JsonProperty("origin")
    private Origin origin;
    @JsonProperty("dest")
    private Dest dest;
    @JsonProperty("estimated_delivery_date")
    private Object estimatedDeliveryDate;
    @JsonProperty("edd_source")
    private Object eddSource;
    @JsonProperty("guaranteed_delivery_date")
    private Object guaranteedDeliveryDate;
    @JsonProperty("service_code")
    private Object serviceCode;
    @JsonProperty("service_description")
    private Object serviceDescription;
    @JsonProperty("events")
    private List<Event> events = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tracking_number")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    @JsonProperty("tracking_number")
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @JsonProperty("carrier_moniker")
    public String getCarrierMoniker() {
        return carrierMoniker;
    }

    @JsonProperty("carrier_moniker")
    public void setCarrierMoniker(String carrierMoniker) {
        this.carrierMoniker = carrierMoniker;
    }

    @JsonProperty("origin")
    public Origin getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @JsonProperty("dest")
    public Dest getDest() {
        return dest;
    }

    @JsonProperty("dest")
    public void setDest(Dest dest) {
        this.dest = dest;
    }

    @JsonProperty("estimated_delivery_date")
    public Object getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    @JsonProperty("estimated_delivery_date")
    public void setEstimatedDeliveryDate(Object estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @JsonProperty("edd_source")
    public Object getEddSource() {
        return eddSource;
    }

    @JsonProperty("edd_source")
    public void setEddSource(Object eddSource) {
        this.eddSource = eddSource;
    }

    @JsonProperty("guaranteed_delivery_date")
    public Object getGuaranteedDeliveryDate() {
        return guaranteedDeliveryDate;
    }

    @JsonProperty("guaranteed_delivery_date")
    public void setGuaranteedDeliveryDate(Object guaranteedDeliveryDate) {
        this.guaranteedDeliveryDate = guaranteedDeliveryDate;
    }

    @JsonProperty("service_code")
    public Object getServiceCode() {
        return serviceCode;
    }

    @JsonProperty("service_code")
    public void setServiceCode(Object serviceCode) {
        this.serviceCode = serviceCode;
    }

    @JsonProperty("service_description")
    public Object getServiceDescription() {
        return serviceDescription;
    }

    @JsonProperty("service_description")
    public void setServiceDescription(Object serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Event> events) {
        this.events = events;
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
