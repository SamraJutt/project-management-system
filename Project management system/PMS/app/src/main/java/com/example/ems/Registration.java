package com.example.ems;

public class Registration {
    private String id;
    private String Name;
    private String Ph_no;
    private String Project;
    private String Status;
    private String CNIC;



    public Registration(String id, String name, String phno, String project, String Status, String CNIC) {
        this.id = id;
        Name = name;
        Ph_no = phno;
        Project = project;
        this.Status = Status;
        this.CNIC = CNIC;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPh_no() {
        return Ph_no;
    }

    public void setPh_no(String ph_no) {
        Ph_no = ph_no;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

}
