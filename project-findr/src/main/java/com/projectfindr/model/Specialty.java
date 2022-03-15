package com.projectfindr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Specialty {
    private String occupationArea;
    private String technologyUsed;
    private String levelKnowledge;

    public Specialty(String occupationArea, String technologyUsed, String levelKnowledge) {
        this.occupationArea = occupationArea;
        this.technologyUsed = technologyUsed;
        this.levelKnowledge = levelKnowledge;
    }
}
