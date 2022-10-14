package org.example.FlowsClass;

public class ProfileFlow {
    private String account;
    private String year;
    private String difficulty;
    private String problemName;
    private String instName;
    private String OrgName;
    private String userName;

    public ProfileFlow(String []arr)
    {
        this.year=arr[2];
        this.difficulty=arr[3];
        this.problemName=arr[4];
        this.instName=arr[5];
        this.OrgName=arr[6];
        this.userName=arr[7];
    }

    public String getAccount() {
        return account;
    }

    public String getYear() {
        return year;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getProblemName() {
        return problemName;
    }

    public String getOrgName() {
        return OrgName;
    }

    public String getUserName() {
        return userName;
    }

    public String getInstName() {
        return instName;
    }
}
