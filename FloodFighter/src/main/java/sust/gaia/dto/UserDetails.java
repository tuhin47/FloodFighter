/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import sust.gia.controller.BasicControl;

/**
 *
 * @author Joker
 */
@Entity
public class UserDetails {

    public static void main(String[] args) {
//        new BasicControl().insert(new UserDetails("tuhin", "tuhin", "tuhin", "01712285805"));

    }

    @Id
    private String userName;
    private String password;
    private String email;
    private String contact;
    private String userType;

    public UserDetails() {
    }

    public UserDetails(String userName, String password, String email, String contact) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
