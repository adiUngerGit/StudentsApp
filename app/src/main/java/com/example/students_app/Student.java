package com.example.students_app;

public class Student {
    public String name;
    public String id;
    public String phon;
    public String address;
    public Boolean cb;

    public Student(String name, String id, String phon,String address, Boolean cb) {
        this.name = name;
        this.id = id;
        this.phon = phon;
        this.address = address;
        this.cb = cb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phon = phone;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}