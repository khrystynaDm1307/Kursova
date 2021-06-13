CREATE DATABASE IF NOT EXISTS `course`;

CREATE TABLE IF NOT EXISTS `role` (
                        `id` bigint(20) not null auto_increment,
                        `name` varchar(255) default null,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS  `usr` (
                        `id` bigint(20) not null auto_increment,
                        `email` varchar(255) default null,
                        `first_name` varchar(255) default null,
                        `last_name` varchar(255) default null,
                        `password` varchar(255) default null,
                        `experience` int,
                        `balance` DECIMAL,
                        `position` varchar(255) default null,
                        `telegram_contacts` varchar(255) default null,
                        `path_to_photo` varchar(255) default null,
                        `discriminator` VARCHAR(20) not null,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_constraint_email` (`email`)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `users_roles` (
                               `user_id` bigint(20) not null,
                               `role_id` bigint(20) not null,
                               PRIMARY KEY (`user_id`, `role_id`),
                               CONSTRAINT `FK_user_constraint` FOREIGN KEY (`user_id`) REFERENCES `usr` (`id`) ON DELETE CASCADE,
                               CONSTRAINT `FK_role_constraint` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `course` (
    `id` bigint(20) not null auto_increment,
    `price` decimal default null,
    `title` varchar(255) not null,
    `description` TEXT not null,
    `bonuses` varchar(255) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `course_mentor` (
    `course_id` bigint(20) not null,
    `mentor_id` bigint(20) not null,
    PRIMARY KEY (`course_id`, `mentor_id`),
    CONSTRAINT `FK_course_constraint` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE,
    CONSTRAINT `FK_mentor_constraint` FOREIGN KEY (`mentor_id`) REFERENCES `usr` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `usr_course` (
                                               `user_id` bigint(20) not null,
                                               `course_id` bigint(20) not null,
                                               PRIMARY KEY (`course_id`, `user_id`),
                                               CONSTRAINT `FK_course_constraint_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ,
                                               CONSTRAINT `FK_user_constraint_2` FOREIGN KEY (`user_id`) REFERENCES `usr` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lesson` (
    `id` bigint(20) not null  auto_increment,
    `title` varchar(255) not null,
    `description` TEXT not null,
    `content` varchar(255) not null,
    `duration` int,
    `course_id` bigint(20) not null,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_course_constraint_3` FOREIGN KEY (`course_id`) REFERENCES course(`id`) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `packet` (
    `id` bigint(20) not null auto_increment,
    `number_of_places` int default 0,
    `title` varchar(255),
    `description` text not null,
    `price` decimal,
    `discount` decimal,
    `path_to_image` varchar(255),
    `course_id` bigint(20) not null,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_course_constraint_4` FOREIGN KEY (`course_id`) REFERENCES course(`id`) ON DELETE CASCADE
) ENGINE = InnoDB;
