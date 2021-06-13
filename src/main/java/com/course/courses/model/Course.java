package com.course.courses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    @JoinTable(
            name = "course_mentor",
            joinColumns = @JoinColumn(
                    name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "mentor_id", referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Mentor> mentorList = new HashSet<>();
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Packet> packetList = new ArrayList<>();
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Lesson> lessonList = new ArrayList<>();

    private BigDecimal price;
    private String title;
    private String description;
    private String bonuses;
}
