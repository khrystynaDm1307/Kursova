package com.course.courses.service;

import com.course.courses.model.Course;
import com.course.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> getById(long id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public void save(Course course) {
         courseRepository.customSave(course.getPrice(), course.getTitle(), course.getDescription(), course.getBonuses());
    }

    public void update(Course course) {
        courseRepository.update(course.getPrice(), course.getTitle(), course.getDescription(), course.getBonuses(), course.getId());
    }
}
