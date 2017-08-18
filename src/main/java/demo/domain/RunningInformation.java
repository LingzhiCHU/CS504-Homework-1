package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    private String runningId;

    private double latitude;
    private double longitude;

    private double runningDistance;
    private double totalRunningTime;
    private double heartRate = 0;
    private Date timestamp = new Date();

    private String healthWarningLevel;

    @Id
    @GeneratedValue                 //not custom mapping
    private long userId;                //field name = column name

    @Embedded
    private UserInfo userInfo;

    public RunningInformation() {

    }

    public RunningInformation(long userId, String runningId,
                              double totalRunningTime,
                              double heartRate,
                              String userName,
                              String userAddress,
                              String healthWarningLevel) {

        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = heartRate;
        this.userId = userId;
        this.userInfo.setUsername(userName);
        this.userInfo.setAddress(userAddress);
        this.healthWarningLevel = healthWarningLevel;
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public double getHeartRate() {
        if (heartRate == 0) {
            heartRate = 60 + (int) (Math.random() * 140);
        }
        return heartRate;
    }

    public String getHealthWarningLevel() {
        if (this.heartRate < 60) {
            this.heartRate = 60 + (int) (Math.random() * 140);
        } else {
            if (this.heartRate <= 75) {
                healthWarningLevel = "LOW";
            } else if (this.heartRate <= 120) {
                healthWarningLevel = "NORMAL";
            } else {
                healthWarningLevel = "HIGH";
            }
        }

        return healthWarningLevel;
    }


    public String getUserName() {
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    public String getUserAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
    }

}

