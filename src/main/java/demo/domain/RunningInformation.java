package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data  // getter & setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)  // default constructor
@Entity  // JPA Mapping
@Table(name = "RUNNING_ANALYSIS")  // JPA Mapping
@JsonInclude(JsonInclude.Include.NON_NULL)  // Json string <=> java object (mapping)
@JsonPropertyOrder({"id", "runningId"})
public class RunningInformation {

    @Id  // mark as id, JPA Mapping
    @GeneratedValue  // generate id automatically
    private Long id;

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp;

    @Embedded  // mark as embedded fields, using JPA mapping
    private UserInfo userInfo;

    private String healthWarningLevel = "";


    @JsonCreator  // use this constructor, Json String to Java Object, using Jackson
    public RunningInformation(@JsonProperty("runningId") String runningId,
                              @JsonProperty("latitude") double latitude,
                              @JsonProperty("longitude") double longitude,
                              @JsonProperty("runningDistance") double runningDistance,
                              @JsonProperty("totalRunningTime") double totalRunningTime,
                              @JsonProperty("heartRate") int heartRate,
                              @JsonProperty("timestamp") Date timestamp,
                              @JsonProperty("username") String username,
                              @JsonProperty("address") String address) {
        this.runningId = runningId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.runningDistance = runningDistance;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = heartRate;
        this.timestamp = timestamp;
        this.userInfo = new UserInfo(username, address);
    }
}












