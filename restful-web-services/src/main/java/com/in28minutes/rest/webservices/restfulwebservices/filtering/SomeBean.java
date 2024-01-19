package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"feild1", "field2"})
public class SomeBean {

    private String feild1;
//    @JsonIgnore
    private String feild2;
    private String feild3;

    public SomeBean(String feild1, String feild2, String feild3) {
        this.feild1 = feild1;
        this.feild2 = feild2;
        this.feild3 = feild3;
    }

    public String getFeild1() {
        return feild1;
    }

    public String getFeild2() {
        return feild2;
    }

    public String getFeild3() {
        return feild3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "feild1='" + feild1 + '\'' +
                ", feild2='" + feild2 + '\'' +
                ", feild3='" + feild3 + '\'' +
                '}';
    }
}
