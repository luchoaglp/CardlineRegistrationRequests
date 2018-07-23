package com.cardlinesrl.controller;

import com.cardlinesrl.exception.ResellerNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ResellerNotFoundException.class)
    public String handleResellerNotFoundException(ResellerNotFoundException exception, Model model) {

        model.addAttribute("back", false);
        model.addAttribute("exceptionMsg", exception.getMessage());

        return "exception";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException exception, Model model) {

        model.addAttribute("back", true);
        model.addAttribute("exceptionMsg", "El comercio ya tiene una solicitud de alta de Sube.");

        return "exception";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String handleException(Exception exception, Model model) {

        model.addAttribute("back", true);
        model.addAttribute("exceptionMsg", "Verifique que la imagen sea menor a 2MB!!");

        return "exception";
    }

}
