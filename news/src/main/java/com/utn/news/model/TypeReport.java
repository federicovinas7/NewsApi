package com.utn.news.model;

public enum TypeReport {
    TEXT("Text"),
    TEXTI("Text and Images"),
    TEXTIV("Text Images and video");

    private String description;

    TypeReport(String description) {
        this.description = description;
    }

    public static TypeReport find(final String value)
    {
        for(TypeReport tp : values())
        {
            if(tp.toString().equalsIgnoreCase(value))
            {
                return tp;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid Report type",value));
    }

    public String getDescription()
    {
        return description;
    }
}
