package com.course.courses.controller;

import com.course.courses.model.Course;
import com.course.courses.service.CourseService;
import com.course.courses.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final MentorService mentorService;
    private final CourseService courseService;

    @Autowired
    public MainController(MentorService mentorService, CourseService courseService) {
        this.mentorService = mentorService;
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String root(ModelMap modelMap) {
        Course course = courseService.getById(1).orElseThrow(() -> new RuntimeException("Course not found."));
        course.getLessonList().subList(0, 3);
        modelMap.addAttribute("course", course);
        return "index";
    }


    @GetMapping("/mentors")
    public String mentors(ModelMap model) {
        model.addAttribute("mentorList", mentorService.getAll());

        return "user/mentors";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
