package com.course.courses.service;

import com.course.courses.model.Role;
import com.course.courses.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role with name: " + name + " not found."));
    }
}
