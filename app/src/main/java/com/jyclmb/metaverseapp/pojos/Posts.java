package com.jyclmb.metaverseapp.pojos;

public class Posts {
    private String id, title, category, description, userid, created_at, updated_at, name;

    public Posts() {
    }

    public Posts(String id, String title, String category, String description, String userid, String created_at, String updated_at, String name) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.userid = userid;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
