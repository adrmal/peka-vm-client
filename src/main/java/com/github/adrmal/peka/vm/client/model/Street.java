package com.github.adrmal.peka.vm.client.model;

import java.util.Objects;

public class Street {

    private String id;
    private String name;

    public Street() {
        // nop
    }

    public Street(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(id, street.id) &&
                Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Street{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
