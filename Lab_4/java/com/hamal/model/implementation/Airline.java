package com.hamal.model.implementation;

import com.hamal.model.BasicModel;

public class Airline implements  BasicModel  {
    private Integer id;
    private String name;

    public Airline(final Integer id, final String name) {
        this.id = id;
        this.name = name;

    }

    public final Integer getId() {
        return id;
    }
    public final void setId(final Integer id) {
        this.id = id;
    }


    public final String getName() {
        return name;
    }
    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", name = " + name
                +'}';
    }
}

