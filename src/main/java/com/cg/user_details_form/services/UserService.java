package com.cg.user_details_form.services;

import com.cg.user_details_form.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void updateFirstLastName(User user, String firstName, String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }
    public void updateEmailPhone(User user, String email, String phone) {
        user.setEmail(email);
        user.setPhone(phone);
    }
    public void updateCityCountry(User user, String city, String country) {
        user.setCity(city);
        user.setCountry(country);
    }
}
