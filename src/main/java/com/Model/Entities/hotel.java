package com.Model.Entities;

public class hotel {
    private Integer id;
    private String classid;
    private String floor;
    private String room;
    private String bed;
    private Integer sex;

   @Override
   public String toString() {
      return "hotel{" +
              "id=" + id +
              ", classid='" + classid + '\'' +
              ", floor='" + floor + '\'' +
              ", room='" + room + '\'' +
              ", bed='" + bed + '\'' +
              ", sex=" + sex +
              '}';
   }

   public Integer getSex() {
      return sex;
   }

   public void setSex(Integer sex) {
      this.sex = sex;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getClassid() {
      return classid;
   }

   public void setClassid(String classid) {
      this.classid = classid;
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

   public String getBed() {
      return bed;
   }

   public void setBed(String bed) {
      this.bed = bed;
   }
}
