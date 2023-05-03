package com.Model.Entities;

public class count {
    private String cout_studentman;
    private String cout_studentwoman;
    private String count_suguan;
    private String count_fudaoyuan;

    public String getCout_studentman() {
        return cout_studentman;
    }

    public void setCout_studentman(String cout_studentman) {
        this.cout_studentman = cout_studentman;
    }

    public String getCout_studentwoman() {
        return cout_studentwoman;
    }

    public void setCout_studentwoman(String cout_studentwoman) {
        this.cout_studentwoman = cout_studentwoman;
    }

    public String getCount_suguan() {
        return count_suguan;
    }

    public void setCount_suguan(String count_suguan) {
        this.count_suguan = count_suguan;
    }

    public String getCount_fudaoyuan() {
        return count_fudaoyuan;
    }

    public void setCount_fudaoyuan(String count_fudaoyuan) {
        this.count_fudaoyuan = count_fudaoyuan;
    }

    @Override
    public String toString() {
        return "count{" +
                "cout_studentman='" + cout_studentman + '\'' +
                ", cout_studentwoman='" + cout_studentwoman + '\'' +
                ", count_suguan='" + count_suguan + '\'' +
                ", count_fudaoyuan='" + count_fudaoyuan + '\'' +
                '}';
    }

    public count(String cout_studentman, String cout_studentwoman, String count_suguan, String count_fudaoyuan) {
        this.cout_studentman = cout_studentman;
        this.cout_studentwoman = cout_studentwoman;
        this.count_suguan = count_suguan;
        this.count_fudaoyuan = count_fudaoyuan;
    }
}
