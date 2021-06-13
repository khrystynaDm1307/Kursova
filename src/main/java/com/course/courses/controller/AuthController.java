package com.course.courses.controller;

import com.course.courses.model.User;
import com.course.courses.model.dto.UserRegistrationDto;
import com.course.courses.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model, HttpServletRequest request) {
        if(request.isUserInRole("USER")) {
            return "redirect:/";
        }

        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if(!userDto.getEmail().equals(userDto.getConfirmEmail())) {
            result.rejectValue("email", null, "Not equals emails");
        }
        if(!userDto.getConfirmPassword().equals(userDto.getPassword())) {
            result.rejectValue("password", null, "Not equals passwords");
        }

        if (result.hasErrors()) {
            return "auth/registration";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if(request.isUserInRole("USER")) {
            return "redirect:/";
        }

        return "auth/login";
    }

}