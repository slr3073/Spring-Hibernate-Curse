package com.slr3073.entities;

import com.slr3073.validators.StartWith;

import javax.validation.constraints.*;

public class Customer {
    public String firstName;

    @NotNull
    @Size(min = 1)
    public String lastName;

    @NotNull(message = "Champ Requit !")
    @Min(value = 0, message = "Doit être supérieur à 0")
    @Max(value = 100, message = "Doit être inférieur à 100")
    public Integer satisfaction;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Doit contenir 5 chiffres")
    public String cp;

    @NotNull(message = "Champ Requit !")
    @Size(min = 1, message = "Champ Requit !")
    @StartWith(value = "SR", message = "Doit commencer par SR")
    public String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
