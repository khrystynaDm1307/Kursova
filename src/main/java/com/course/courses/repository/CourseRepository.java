package com.course.courses.repository;

import com.course.courses.model.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM course.course WHERE course.course.id=?1 ")
    Optional<Course> findById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM course.course ")
    Iterable<Course> findAll();

    @Query(nativeQuery = true, value = "DELETE FROM course.course WHERE course.course.id=?1")
    @Modifying
    void deleteById(long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO course(price, title, description, bonuses) VALUES (?1, ?2, ?3, ?4)")
    void customSave(@Param("price") BigDecimal price, @Param("title") String title, @Param("description") String description, @Param("bonuses") String bonuses);

    @Query(nativeQuery = true, value = "UPDATE course.course SET price=?1, title=?2, description=?3, bonuses=?4 WHERE id=?5")
    @Transactional
    @Modifying
    void update(BigDecimal price, String title, String description, String bonuses, long id);
}
