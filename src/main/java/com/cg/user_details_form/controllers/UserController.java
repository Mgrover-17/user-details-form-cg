package com.cg.user_details_form.controllers;

import com.cg.user_details_form.models.User;
import com.cg.user_details_form.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-details")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/firstpage")
    public String showFirstPage() {
        return "firstPage";
    }

    @PostMapping("/firstpage")
    public String handleFirstPage(@ModelAttribute("") User user,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName) {
        userService.updateFirstLastName(user, firstName, lastName);
        return "redirect:/user-details/secondpage";
    }
    @GetMapping("/secondpage")
    public String showSecondPage() {
        return "secondPage";
    }

    @PostMapping("/secondpage")
    public String handleSecondPage(@ModelAttribute("user") User user,
                                   @RequestParam String email,
                                   @RequestParam String phone) {
        userService.updateEmailPhone(user, email, phone);
        return "redirect:/user-details/thirdpage";
    }

    @GetMapping("/thirdpage")
    public String showThirdPage() {
        return "thirdPage";
    }


    @PostMapping("/thirdpage")
    public String handleThirdPage(@ModelAttribute("user") User user,
                                   @RequestParam String city,
                                   @RequestParam String country) {
        userService.updateCityCountry(user, city, country);
        return "redirect:/user-details/fourthpage";
    }

    @GetMapping("/fourthpage")
    public String showFourthPage() {
        return "fourthPage";
    }

}
