package com.nisum.usuario.vo;

public class UserVO {

    private int id;

    private String name;

    private String email;

    private String password;

    private PhoneVO[] phones;

    public UserVO() {
    }

    public UserVO(int id, String name, String email, String password, PhoneVO[] phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PhoneVO[] getPhones() {
        return phones;
    }

    public void setPhones(PhoneVO[] phones) {
        this.phones = phones;
    }
}
