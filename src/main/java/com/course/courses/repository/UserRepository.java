package com.course.courses.repository;

import com.course.courses.model.Course;
import com.course.courses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM usr LEFT OUTER JOIN usr_course ON usr.id = usr_course.user_id  LEFT OUTER JOIN course ON usr_course.course_id = course.id" +
            " LEFT OUTER JOIN users_roles ON usr.id = users_roles.user_id LEFT OUTER JOIN role ON role.id = users_roles.role_id" +
            " WHERE usr.email=?1")
    User findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM usr LEFT OUTER JOIN usr_course ON usr.id = usr_course.user_id " +
            " WHERE usr.id=?1")
    Optional<User> findById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM usr")
    List<User> findAll();

    @Query(nativeQuery = true, value = "DELETE FROM usr WHERE usr.id=?1")
    @Modifying
    void deleteById(long id);

    @Query(nativeQuery = true, value = "UPDATE usr SET password=?1  WHERE id=?2")
    @Transactional
    @Modifying
    void update(String password, long id);
}