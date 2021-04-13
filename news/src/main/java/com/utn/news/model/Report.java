package com.utn.news.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeReport",visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextReport.class, name = "TEXT"),
        @JsonSubTypes.Type(value = ImagesReport.class, name = "TEXTI"),
        @JsonSubTypes.Type(value = VideoReport.class, name = "TEXTIV")
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Report {

    @Id
    private Integer id;
    @NotNull(message="title cannot be set to null")
    private String title;
    private String header;
    private String body;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypeReport typeReport();


}
