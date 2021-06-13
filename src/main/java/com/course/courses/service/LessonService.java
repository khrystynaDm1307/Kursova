package com.course.courses.service;

import com.course.courses.model.Lesson;
import com.course.courses.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson getById(long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson with id " + id + " not found"));
    }

    public List<Lesson> getAll() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public void save(Lesson lesson) {
        lessonRepository.customSave(lesson.getTitle(), lesson.getDescription(), lesson.getContent(), lesson.getDuration(), lesson.getCourse().getId());
    }

    public void update(Lesson lesson) {
        lessonRepository.update(lesson.getTitle(), lesson.getDescription(), lesson.getContent(), lesson.getDuration(), lesson.getCourse().getId(), lesson.getId());
    }

    public void deleteById(long id) {
        lessonRepository.deleteById(id);
    }
}
