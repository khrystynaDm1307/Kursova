package com.course.courses.controller;

import com.course.courses.model.Course;
import com.course.courses.model.User;
import com.course.courses.service.CourseService;
import com.course.courses.service.MentorService;
import com.course.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;
    private final MentorService mentorService;

    @Autowired
    public CourseController(CourseService courseService, UserService userService, MentorService mentorService) {
        this.courseService = courseService;
        this.userService = userService;
        this.mentorService = mentorService;
    }

    @GetMapping("/{id}")
    public String getCourseDetailsPage(@PathVariable("id") long courseId, ModelMap modelMap) {
        Course course = courseService.getById(courseId).orElseThrow(() -> new RuntimeException("Course with id: " + courseId + " not found."));

        modelMap.addAttribute("course", course);
        return "course/course-details";
    }

    @GetMapping("/packet/{id}")
    @PreAuthorize("hasRole('USER')")
    public String getCoursePacketsPage(@PathVariable("id") long courseId, ModelMap modelMap) {
        Course course = courseService.getById(courseId).orElseThrow(() -> new RuntimeException("Course with id: " + courseId + " not found"));

        if(course.getPacketList().size() > 0) {
            modelMap.addAttribute("packetList", course.getPacketList());
            modelMap.addAttribute("course", course);

            return "course/packets";
        } else {
            return "redirect:/buy/{id}";
        }
    }

    @GetMapping(value = {"/update/{id}", "/update" })
    @PreAuthorize("hasRole('ADMIN')")
    public String getCourseUpdatePage(@PathVariable(value =  "id", required = false) Long id, ModelMap modelMap) {
        modelMap.addAttribute("mentorList", mentorService.getAll());

        if(id != null) {
            Course course = courseService.getById(id).orElseThrow(() -> new RuntimeException("Course with id: " + id + " not found."));
            modelMap.addAttribute("course", course);
        } else {
            modelMap.addAttribute("course", new Course());
        }

        return "course/update";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateCourse(Course course) {
        if(course.getId() == 0) {
            courseService.save(course);
            return "redirect:/course/all";
        } else {
            Course courseToUpdate = courseService.getById(course.getId()).orElseThrow(() -> new RuntimeException("Course with id: " + course.getId() + " not found."));
            courseToUpdate.setPrice(course.getPrice());
            courseToUpdate.setTitle(course.getTitle());
            courseToUpdate.setDescription(course.getDescription());
            courseToUpdate.setBonuses(course.getBonuses());
            courseToUpdate.setMentorList(course.getMentorList());

            courseService.update(courseToUpdate);
            return "redirect:/course/" + course.getId();
        }
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCourse(@PathVariable("id") long id) {
        courseService.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/all")
    public String getAllCourses(ModelMap modelMap) {
        modelMap.addAttribute("courseList", courseService.getAll());

        return "course/course";
    }

    @PostMapping("/buy")
    @PreAuthorize("hasRole('USER')")
    public String buyCourse(@RequestParam("id") long courseId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());

        Course course = courseService.getById(courseId).orElseThrow(() -> new RuntimeException("Course with id: " + courseId + " not found."));
        Set<Course> courses = user.getCourses();
        courses.add(course);

        user.setCourses(courses);
        userService.update(user);
        return "redirect:/user";
    }
}
