package com.Model.Entities;


import java.util.Date;

public class elepower {
    private Integer id;
    private String floor;
    private String room;
    private float yue;
    private float addmoney;
    private java.sql.Date thedate;
    private Integer status;
    private String start_date;
    private String end_date;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public float getYue() {
        return yue;
    }

    public void setYue(float yue) {
        this.yue = yue;
    }

    public float getAddmoney() {
        return addmoney;
    }

    public void setAddmoney(float addmoney) {
        this.addmoney = addmoney;
    }

    public java.sql.Date getThedate() {
        return thedate;
    }

    @Override
    public String toString() {
        return "elepower{" +
                "id=" + id +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", yue=" + yue +
                ", addmoney=" + addmoney +
                ", thedate=" + thedate +
                ", status=" + status +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }

    public void setThedate(java.sql.Date thedate) {
        this.thedate = thedate;
    }
}
