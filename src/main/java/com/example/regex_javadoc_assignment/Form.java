package com.example.regex_javadoc_assignment;

import javafx.scene.control.TextField;

import java.util.Date;

public class Form {
    private String FirstName;
    private String LastName;
    private String Email;
    private Date DateofBirth;
    private String ZipCode;

    // no parem Constructor
    public Form() {
    }

    // Getters and Setters
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Date getDateofBirth() {
        return DateofBirth;
    }
    public void setDateofBirth(Date dateofBirth) {
        DateofBirth = dateofBirth;
    }
    public String getZipCode() {
        return ZipCode;
    }
    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }
}
