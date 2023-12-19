package idusw.javaweb.openapia.model;

import java.sql.Timestamp;

public class ProjectDTO {
    private Long pid;
    private String projectName;
    private String projectDescription;
    private String status;
    private String clientCompany;
    private String projectLeader;
    private Long estimatedBudget;
    private Long totalAmountSpent;
    private Long estimatedProjectDuration;
    private Timestamp regTimestamp;
    private Timestamp revTimestamp;
    private String projectImage;

    public Timestamp getRegTimestamp() {
        return regTimestamp;
    }

    public void setRegTimestamp(Timestamp regTimestamp) {
        this.regTimestamp = regTimestamp;
    }

    public Timestamp getRevTimestamp() {
        return revTimestamp;
    }

    public void setRevTimestamp(Timestamp revTimestamp) {
        this.revTimestamp = revTimestamp;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public Long getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Long estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public Long getTotalAmountSpent() {
        return totalAmountSpent;
    }

    public void setTotalAmountSpent(Long totalAmountSpent) {
        this.totalAmountSpent = totalAmountSpent;
    }

    public Long getEstimatedProjectDuration() {
        return estimatedProjectDuration;
    }

    public void setEstimatedProjectDuration(Long estimatedProjectDuration) {
        this.estimatedProjectDuration = estimatedProjectDuration;
    }
}
