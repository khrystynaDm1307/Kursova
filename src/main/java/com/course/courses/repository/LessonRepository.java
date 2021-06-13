package com.course.courses.repository;

import com.course.courses.model.Course;
import com.course.courses.model.Lesson;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM lesson INNER JOIN course ON lesson.course_id = course.id WHERE lesson.id=?1 ")
    Optional<Lesson> findById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM lesson INNER JOIN course ON lesson.course_id = course.id ")
    Iterable<Lesson> findAll();

    @Query(nativeQuery = true, value = "DELETE FROM lesson WHERE lesson.id=?1")
    @Modifying
    void deleteById(long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO lesson(title, description, content, duration, course_id) VALUES (?1, ?2, ?3, ?4, ?5)")
    void customSave(String title, String description, String content, int duration, long courseId);

    @Query(nativeQuery = true, value = "UPDATE lesson SET title=?1, description=?2, content=?3, duration=?4, course_id=?5 WHERE id=?6")
    @Transactional
    @Modifying
    void update(String title, String description, String content, int duration, long courseId, long lessonId);
}
