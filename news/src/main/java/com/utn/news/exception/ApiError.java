package com.utn.news.exception;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@AllArgsConstructor
public class ApiError {

    private HttpStatus httpStatus;
    private String message;
    @Nullable
    private List<String> errors;
}
