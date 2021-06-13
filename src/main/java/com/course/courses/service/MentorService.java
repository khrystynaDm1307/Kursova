package com.course.courses.service;

import com.course.courses.model.Mentor;
import com.course.courses.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getAll() {
        return (List<Mentor>) mentorRepository.findAll();
    }
}
