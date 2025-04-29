package com.cg.user_details_form.services;

import com.cg.user_details_form.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void updateFirstLastName(UserDTO userDTO, String firstName, String lastName) {
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
    }
    public void updateEmailPhone(UserDTO userDTO, String email, String phone) {
        userDTO.setEmail(email);
        userDTO.setPhone(phone);
    }
    public void updateCityCountry(UserDTO userDTO, String city, String country) {
        userDTO.setCity(city);
        userDTO.setCountry(country);
    }
}
