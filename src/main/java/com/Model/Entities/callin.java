package com.Model.Entities;

public class callin {
    private Integer id;
    private String callfromname;
    private String callfromphone;
    private String relationship;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCallfromname() {
        return callfromname;
    }

    @Override
    public String toString() {
        return "callin{" +
                "id=" + id +
                ", callfromname='" + callfromname + '\'' +
                ", callfromphone='" + callfromphone + '\'' +
                ", relationship='" + relationship + '\'' +
                ", callofname='" + callofname + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", thetime='" + thetime + '\'' +
                '}';
    }

    public void setCallfromname(String callfromname) {
        this.callfromname = callfromname;
    }

    public String getCallfromphone() {
        return callfromphone;
    }

    public void setCallfromphone(String callfromphone) {
        this.callfromphone = callfromphone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCallofname() {
        return callofname;
    }

    public void setCallofname(String callofname) {
        this.callofname = callofname;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getThetime() {
        return thetime;
    }

    public void setThetime(String thetime) {
        this.thetime = thetime;
    }

    private String callofname;
    private String floor;
    private String room;
    private String thetime;
}
