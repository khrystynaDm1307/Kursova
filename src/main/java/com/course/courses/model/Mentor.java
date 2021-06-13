package com.course.courses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("mentor")
public class Mentor extends User {

    private String position;
    private int experience;
    @Column(name = "telegram_contacts")
    private String telegramContacts;
    @Column(name = "path_to_photo")
    private String pathToPhoto;
}
