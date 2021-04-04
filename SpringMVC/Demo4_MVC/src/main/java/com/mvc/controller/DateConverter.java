package com.mvc.controller;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter implements Converter {
    @Override
    public Object convert(Object source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse((String) source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
