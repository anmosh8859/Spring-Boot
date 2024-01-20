package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){

        SomeBean someBean = new SomeBean("v1","v2","v3");
        FilterProvider filter = new SimpleFilterProvider().addFilter("SimpleFilter", SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2") );
        MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
        jacksonValue.setFilters(filter);
        System.out.println(jacksonValue.getSerializationView());

        return jacksonValue;
    }
}