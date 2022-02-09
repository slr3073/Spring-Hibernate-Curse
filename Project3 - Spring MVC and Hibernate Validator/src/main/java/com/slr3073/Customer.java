package com.slr3073;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    public String firstName;

    @NotNull
    @Size(min = 1)
    public String lastName;

    @Min(value = 0, message = "Doit être supérieur à 0")
    @Max(value = 100, message = "Doit être inférieur à 100")
    public int satisfaction;

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

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }
}
