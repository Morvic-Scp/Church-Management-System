/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Morvic
 */
public class registrationSub {    
    
    private String FirstName;
    private String otherName;
    private String age;
    private String town;
    private String telnumber;
    private String email;
    private String fellowship;
    private String gender;

    public registrationSub(String FirstName, String otherName, String age, String town, String telnumber, String email, String fellowship, String gender) {
        this.FirstName = FirstName;
        this.otherName = otherName;
        this.age = age;
        this.town = town;
        this.telnumber = telnumber;
        this.email = email;
        this.fellowship = fellowship;
        this.gender = gender;
    }



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFellowship() {
        return fellowship;
    }

    public void setFellowship(String fellowship) {
        this.fellowship = fellowship;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    

}
