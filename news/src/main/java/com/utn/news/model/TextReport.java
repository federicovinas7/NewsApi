package com.utn.news.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class TextReport extends Report {
    @Override
    public TypeReport typeReport() {
        return TypeReport.TEXT;
    }
}
