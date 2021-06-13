package com.course.courses.repository;

import com.course.courses.model.Mentor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM usr WHERE discriminator='mentor'")
    Iterable<Mentor> findAll();
}
