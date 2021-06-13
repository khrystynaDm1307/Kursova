package com.course.courses.controller;

import com.course.courses.model.Course;
import com.course.courses.model.Lesson;
import com.course.courses.model.User;
import com.course.courses.service.CourseService;
import com.course.courses.service.LessonService;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public LessonController(LessonService lessonService, CourseService courseService, UserService userService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping(value = {"/update/{courseId}/{lessonId}", "/update/{courseId}" })
    @PreAuthorize("hasRole('ADMIN')")
    public String getLessonUpdatePage(@PathVariable(value =  "lessonId", required = false) Long lessonId, @PathVariable(value = "courseId", required = false) Long courseId, ModelMap modelMap) {
        modelMap.addAttribute("lessonList", lessonService.getAll());

        if(lessonId != null) {
            Lesson lesson = lessonService.getById(lessonId);
            modelMap.addAttribute("lesson", lesson);
        } else {
            Lesson lesson = new Lesson();
            Course course = new Course();
            course.setId(courseId);

            lesson.setCourse(course);
            modelMap.addAttribute("lesson", lesson);
        }

        return "lesson/update";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateLesson(Lesson lesson) {
        if(lesson.getId() == 0) {
            Course course = courseService.getById(lesson.getCourse().getId()).orElseThrow(() -> new RuntimeException("Course not found!"));
            course.getLessonList().add(lesson);
            courseService.save(course);

            lesson.setCourse(course);
            lessonService.save(lesson);
        } else {
            Lesson lessonToUpdate = lessonService.getById(lesson.getId());
            lessonToUpdate.setTitle(lesson.getTitle());
            lessonToUpdate.setDescription(lesson.getDescription());
            lessonToUpdate.setContent(lesson.getContent());
            lessonToUpdate.setDuration(lesson.getDuration());

            lessonService.update(lessonToUpdate);
        }

        return "lesson/lesson";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public String getLessonPage(@PathVariable("id") long id, ModelMap modelMap) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByEmail(userDetails.getUsername());
        Lesson lesson = lessonService.getById(id);
        if(currentUser.getCourses().stream().noneMatch(course -> course.getId() == lesson.getCourse().getId())) {
            return "redirect:/course/" + lesson.getCourse().getId();
        }

        modelMap.addAttribute("lesson", lessonService.getById(id));
        return "lesson/lesson";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteLesson(@PathVariable("id") long id) {
        lessonService.deleteById(id);

        return "redirect:/course/all";
    }


}
