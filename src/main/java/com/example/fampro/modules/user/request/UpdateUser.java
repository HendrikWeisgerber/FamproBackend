package com.example.fampro.modules.user.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter
public class UpdateUser {

    @Size(min=2, max=30, message = "Your choosen firstname must be between 2 and 30 signs long")
    private String firstName;

    @Size(min= 2, max= 30, message = "Your choosen lastname must be between 2 and 30 signs long")
    private String lastName;


    public UpdateUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
