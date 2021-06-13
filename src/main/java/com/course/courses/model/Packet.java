package com.course.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number_of_places")
    private int numberOfPlaces;
    private String title;
    private String description;
    private BigDecimal price;
    private int discount;
    @Column(name = "path_to_image")
    private String pathToImage;
    @ManyToOne
    private Course course;

    public BigDecimal getPriceWithDiscount() {
        BigDecimal discountedValue = price.multiply(BigDecimal.valueOf(discount)).divide(BigDecimal.valueOf(100));
        return price.subtract(discountedValue);
    }
}
