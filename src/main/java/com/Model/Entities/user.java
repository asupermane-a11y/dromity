package com.Model.Entities;

public class user {
    private Integer id;
    private Integer sex;
    private String phone;
    private String email;
    private Integer capacity;
    private String home_adress;
    private String password;
    private String classid;

    public user() {
    }

    private Integer floor;
    private Integer room;
    private Integer bed;

    public user(Integer id, Integer sex, String phone, String email, Integer capacity, String home_adress, String password, String classid, Integer floor, Integer room, Integer bed, String studentid, String college, String mysystem, String name, String professional) {
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.capacity = capacity;
        this.home_adress = home_adress;
        this.password = password;
        this.classid = classid;
        this.floor = floor;
        this.room = room;
        this.bed = bed;
        this.studentid = studentid;
        this.college = college;
        this.mysystem = mysystem;
        this.name = name;
        this.professional = professional;
    }

    private String studentid;
    private String college;
    private String mysystem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMysystem() {
        return mysystem;
    }

    public void setMysystem(String mysystem) {
        this.mysystem = mysystem;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    private String professional;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getHome_adress() {
        return home_adress;
    }

    public void setHome_adress(String home_adress) {
        this.home_adress = home_adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", capacity=" + capacity +
                ", home_adress='" + home_adress + '\'' +
                ", password='" + password + '\'' +
                ", classid='" + classid + '\'' +
                ", floor=" + floor +
                ", room=" + room +
                ", bed=" + bed +
                ", studentid='" + studentid + '\'' +
                ", college='" + college + '\'' +
                ", mysystem='" + mysystem + '\'' +
                ", name='" + name + '\'' +
                ", professional='" + professional + '\'' +
                '}';
    }
}
