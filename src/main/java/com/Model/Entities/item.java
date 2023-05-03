package com.Model.Entities;



public class item {
    private Integer id;
    private String itemname;
    private Integer floor;
    private String  place;
    private String  all_place;
    private String  describ;
    private String  personname;
    private Integer capacity;
    private String  itemid;
    private Integer status;
    private String phone;
    private String images;

    @Override
    public String toString() {
        return "item{" +
                "id=" + id +
                ", itemname='" + itemname + '\'' +
                ", floor=" + floor +
                ", place='" + place + '\'' +
                ", all_place='" + all_place + '\'' +
                ", describ='" + describ + '\'' +
                ", personname='" + personname + '\'' +
                ", capacity=" + capacity +
                ", itemid='" + itemid + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", images='" + images + '\'' +
                '}';
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAll_place() {
        return all_place;
    }

    public void setAll_place(String all_place) {
        this.all_place = all_place;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }
}
