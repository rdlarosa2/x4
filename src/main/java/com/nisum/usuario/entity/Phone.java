package com.nisum.usuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="userid")
    int userId;

    @Column(name="number")
    private String number;

    @Column(name="citycode")
    private String citycode;

    @Column(name="countrycode")
    private String countrycode;

    public Phone() {
    }

    public Phone(int theUserId, String number, String citycode, String countrycode) {
        this.userId = theUserId;
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }
}
