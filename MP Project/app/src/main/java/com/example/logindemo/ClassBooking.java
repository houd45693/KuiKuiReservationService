package com.example.logindemo;

public class ClassBooking {
    private String checkinDate;
    private String checkoutDate;
    private String bookingNum;
    private Integer wedding,birthday,special ;

    public ClassBooking() {
    }

    public ClassBooking(String checkindate, String checkoutdate, Integer wedding, Integer birthday, Integer special, String bookingNumber) {
        this.checkinDate = checkindate;
        this.checkoutDate = checkoutdate;
        this.bookingNum = bookingNum;
        this.wedding = wedding;
        this.birthday = birthday;
        this.special = special;

    }

    public String getCheckindate() {
        return checkinDate;
    }

    public void setCheckindate(String checkindate) {
        this.checkinDate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutDate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutDate = checkoutdate;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public Integer getWedding() {
        return wedding;
    }

    public void setWedding(Integer wedding) {
        this.wedding = wedding;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special= special ;
    }


}



