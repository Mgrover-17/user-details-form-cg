package com.cg.user_details_form.controllers;

import com.cg.user_details_form.dto.UserDTO;
import com.cg.user_details_form.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-details")
@SessionAttributes("userDto")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userDto")
    public UserDTO userDto() {
        return new UserDTO();
    }

    @GetMapping("/firstpage")
    public String showFirstPage() {
        return "firstPage";
    }

    @PostMapping("/firstpage")
    public String handleFirstPage(@ModelAttribute("userDto") UserDTO userDto,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName) {
        userService.updateFirstLastName(userDto, firstName, lastName);
        return "secondPage";
    }

    @PostMapping("/secondpage")
    public String handleSecondPage(@ModelAttribute("userDto") UserDTO userDto,
                                   @RequestParam String email,
                                   @RequestParam String phone) {
        userService.updateEmailPhone(userDto, email, phone);
        return "thirdPage";
    }

    @PostMapping("/thirdpage")
    public String handleThirdPage(@ModelAttribute("userDto") UserDTO userDto,
                                   @RequestParam String city,
                                   @RequestParam String country) {
        userService.updateCityCountry(userDto, city, country);
        return "redirect:/user-details/fourthpage";
    }

    @GetMapping("/fourthpage")
    public String showFourthPage() {
        return "fourthPage";
    }

}
