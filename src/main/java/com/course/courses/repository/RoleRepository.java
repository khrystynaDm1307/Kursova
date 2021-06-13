package com.course.courses.repository;

import com.course.courses.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(nativeQuery = true, value = "SELECT role.id, role.name FROM role WHERE role.name=?1")
    Optional<Role> findByName(String name);
}
