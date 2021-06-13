package com.course.courses.controller;

import com.course.courses.service.CourseService;
import com.course.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public AdminController(CourseService courseService, UserService userService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap, HttpServletRequest request) {
        if(!request.isUserInRole("ADMIN")) {
            return "redirect:/";
        }

        modelMap.addAttribute("userList", userService.getAll());
        modelMap.addAttribute("courseList", courseService.getAll());
        return "user/admin";
    }
}
