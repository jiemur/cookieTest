package com.wzn.pojo;  /*这个包里面放表*/

public class User {   //一类一表
    private int id;   //id
    private String username;   //用户名
    private String password;   //密码
    private String tele;   //电话号码
    /*构造方法*/
    public User() {
    }

    public User(int id, String username, String password, String tele) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tele = tele;
    }
    /*get和set*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
    /*toString*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
