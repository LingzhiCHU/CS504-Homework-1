package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RunningInfo extends RunningInformation{
    @Id
    @GeneratedValue                 //not custom mapping
    private long userId;                //field name = column name
    private String runningId;
    private double totalRunningTime;
    private double heartRate;
    private String userName;
    private String userAddress;
    private String healthWarningLevel;


    public long getUserId() {
        this.userId = super.getUserId();
        return userId;
    }

    public String getRunningId() {
        this.runningId = super.getRunningId();
        return runningId;
    }

    public double getTotalRunningTime() {
        this.totalRunningTime = super.getTotalRunningTime();
        return totalRunningTime;
    }

    public double getHeartRate() {
        this.heartRate = super.getHeartRate();
        return heartRate;
    }

    public String getUserName() {
        this.userName = super.getUserName();
        return userName;
    }

    public String getUserAddress() {
        this.userAddress = super.getUserAddress();
        return userAddress;
    }

    public String getHealthWarningLevel() {
        return healthWarningLevel;
    }


    public RunningInfo(){

    }







}
