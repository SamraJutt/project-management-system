package com.example.ems;

public class Project {
    private String Title;
    private String manager;
    private String Description;
    private String budget;
    private String Date;
    private String Type;
    private String status;
    private String id;





    public Project(String title, String manager, String description, String budget, String date, String Type, String status, String id) {
        Title = title;
        this.manager = manager;
        Description = description;
        this.budget = budget;
        Date = date;
        this.Type = Type;
        this.status = status;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

