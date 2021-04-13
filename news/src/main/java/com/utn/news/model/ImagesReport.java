package com.utn.news.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor

public class ImagesReport extends Report {
    @Override
    public TypeReport typeReport() {
        return TypeReport.TEXTI;
    }
}
