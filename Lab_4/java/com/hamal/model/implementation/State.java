package com.hamal.model.implementation;

import com.hamal.model.BasicModel;

public class State implements  BasicModel  {
    private Integer id;
    private String state;

    public State(final Integer id, final String state) {
        this.id = id;
        this.state = state;

    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String name) {
        this.state = state;
    }

    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", name = " + state
                +'}';
    }
}

