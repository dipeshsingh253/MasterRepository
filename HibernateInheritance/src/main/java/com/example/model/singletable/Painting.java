package com.example.model.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "PAINTING")
public class Painting extends ArtPiece{

    @Enumerated(value = EnumType.STRING)
    private PaintingStyle paintingStyle;
    private Double height;
    private Double width;

    public Painting() {
    }

    public Painting(String author, PaintingStyle paintingStyle, Double height, Double width) {
        super(author);
        this.paintingStyle = paintingStyle;
        this.height = height;
        this.width = width;
    }
}
