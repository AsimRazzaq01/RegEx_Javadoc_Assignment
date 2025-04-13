package com.example.regex_javadoc_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import java.util.regex.Pattern;

/**
 * RegisterFormController -> RegisterForm-view.fxml
 * @author Asim Razzaq
 * @version 1.0
 * @since 4/13/2025
 */
public class RegisterFormController {
    // GUI
    // Text Fields
    @FXML
    private TextField DOB_txtfield;
    @FXML
    private TextField Email_txtfield;
    @FXML
    private TextField FirstName_txtfield;
    @FXML
    private TextField LastName_txtfield;
    @FXML
    private TextField ZipCode_txtfield;
    // button
    @FXML
    private Button Register_Button;
    // label
    @FXML
    private Label Label_txtField;

    /**
     *
     * @param event  ->  Action on click for -> register button
     */
    @FXML
    private void CreateForm_OnClick(ActionEvent event)   {
        Label_txtField.setText("Successfully Registered User !");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully Registered User !");
        alert.setHeaderText("Successfully Registered User");
        alert.show();
    }

    //  Variable
    public boolean valid;

    /**
     * innit
     */
    public void initialize() {
        Register_Button.setDisable(true);
        CheckValidationListeners();
    }

    /**
     *     // Add input validation using regular expressions (Regex) as follows:
     *     //First Name and Last Name: Minimum of 2 characters and maximum of 25 characters.
     *     //Date of Birth: Should be in MM/DD/YYYY format.
     *     //Email: Should accept only farmingdale valid email addresses.
     *     //Zip Code: Should be 5-digit numbers.
     */
    private void inputValidation() {
        // variables
        valid = true;
        StringBuilder ValidationMessage = new StringBuilder();
        Label_txtField.setText(ValidationMessage.toString());
        String CollegeEmail = "@farmingdale.edu" ;

        // First Name
        if (FirstName_txtfield.getText().isEmpty()) {
            valid = false;
            ValidationMessage.append("FirstName is required. \n");
        }
        else if (! FirstName_txtfield.getText().matches("^[a-zA-Z]{2,25}$")) {
            valid = false;
            ValidationMessage.append("FirstName is invalid. \n");
        }

        // Last Name
        if (LastName_txtfield.getText().isEmpty()) {
            valid = false;
            ValidationMessage.append("LastName is required. \n");
        }
        else if (! LastName_txtfield.getText().matches("^[a-zA-Z]*$") ) {
            valid = false;
            ValidationMessage.append("LastName is invalid. \n");
        }

        //  Email
        if (Email_txtfield.getText().isEmpty()) {
            valid = false;
            ValidationMessage.append("Email is required. \n");
        }
        else if (! Email_txtfield.getText().matches("^[a-zA-Z0-9._%+-]*" + Pattern.quote(CollegeEmail) + "$" )) {
            //  && LastName_txtfield.getText().contains(CollegeEmail)
            valid = false;
            ValidationMessage.append("Email is invalid. \n");
        }

        // DOB
        if (DOB_txtfield.getText().isEmpty()) {
            valid = false;
            ValidationMessage.append("DOB is required. \n");
        } else if (! DOB_txtfield.getText().matches("^(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])/\\d{4}$")) {
            valid = false;
            ValidationMessage.append("DOB is invalid format = MM/DD/YYYY. \n");
        }

        //  Zip Code
        if (ZipCode_txtfield.getText().isEmpty()) {
            valid = false;
            ValidationMessage.append("ZipCode is required. \n"); // (0-4) = 5
        } else if (ZipCode_txtfield.getText().matches("^[0-9]{4}$")) {
            valid = false;
            ValidationMessage.append("ZipCode is invalid. \n");
        }

        //  if valid is not true button is disabled
        Register_Button.setDisable(! valid);
        //  Show all messages
        Label_txtField.setText(ValidationMessage.toString());

    }   // End inputValidation method

    /**
     * Listener to check each variable for validation
     */
    private void CheckValidationListeners(){
        ChangeListener<Boolean> ValidityListener = (observable, oldValue, newValue) -> inputValidation();

        //  Listener for all fields
        FirstName_txtfield.focusedProperty().addListener(ValidityListener);
        LastName_txtfield.focusedProperty().addListener(ValidityListener);
        Email_txtfield.focusedProperty().addListener(ValidityListener);
        DOB_txtfield.focusedProperty().addListener(ValidityListener);
        ZipCode_txtfield.focusedProperty().addListener(ValidityListener);
    }   // End CheckValidationListeners

}   // End RegisterFormController



