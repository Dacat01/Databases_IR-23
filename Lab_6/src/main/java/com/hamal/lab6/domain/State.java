package com.hamal.lab6.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "state", schema = "hamal_db")
public class State{
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "State")
    private String state;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state1 = (State) o;

        if (id != null ? !id.equals(state1.id) : state1.id != null) return false;
        if (state != null ? !state.equals(state1.state) : state1.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
