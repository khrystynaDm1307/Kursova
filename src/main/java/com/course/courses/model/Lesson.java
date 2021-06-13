package com.course.courses.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int duration;
    private String title;
    private String description;
    private String content;
    @ManyToOne
    private Course course;


}
