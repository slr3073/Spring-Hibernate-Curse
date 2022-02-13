package com.slr3073.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(length = 1000, name = "comment")
    private String comment;

    public Review(String comment) {
        this.comment = comment;
    }
}
