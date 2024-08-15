package com.morning.framework.config ;

import com.morning.framework.common.Result;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        String errorMsg = errors.stream().map(item ->  ((FieldError)item).getField() + ":" + item.getDefaultMessage()).collect(Collectors.joining(" "));
        return Result.fail(40001, errorMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleExceptions(Exception ex) {
        return Result.fail(500, ex.getMessage());
    }

}