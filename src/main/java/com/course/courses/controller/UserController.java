package com.course.courses.controller;

import com.course.courses.model.User;
import com.course.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(ModelMap model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());

        model.addAttribute("user", user);
        return "user/user";
    }

    @PostMapping("/user/change-password")
    @PreAuthorize("hasRole('USER')")
    public String postChangePassword(@RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword, ModelMap modelMap) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByEmail(userDetails.getUsername());

        if(!userService.changePassword(currentUser, oldPassword, newPassword)) {
            modelMap.addAttribute("error", "You entered wrong password");
            modelMap.addAttribute("user", currentUser);
            return "user/user";
        } else {
            modelMap.addAttribute("success", "Password successfully changed");
        }

        return "redirect:/user";
    }

    @PostMapping("/user/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String postDeleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);

        return "redirect:/admin";
    }
}
