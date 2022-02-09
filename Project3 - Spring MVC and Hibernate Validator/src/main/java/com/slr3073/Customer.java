package com.slr3073;

import javax.validation.constraints.*;

public class Customer {
    public String firstName;

    @NotNull
    @Size(min = 1)
    public String lastName;

    @Min(value = 0, message = "Doit être supérieur à 0")
    @Max(value = 100, message = "Doit être inférieur à 100")
    public int satisfaction;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Doit contenir 5 chiffres")
    public String cp;

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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}
