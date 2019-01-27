package com.github.adrmal.peka.vm.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Direction {

    private boolean returnVariant;
    @SerializedName("direction")
    private String lineDirection;
    private String lineName;

    public Direction() {
        // nop
    }

    public Direction(boolean returnVariant, String lineDirection, String lineName) {
        this.returnVariant = returnVariant;
        this.lineDirection = lineDirection;
        this.lineName = lineName;
    }

    public boolean isReturnVariant() {
        return returnVariant;
    }

    public String getLineDirection() {
        return lineDirection;
    }

    public String getLineName() {
        return lineName;
    }

    public void setReturnVariant(boolean returnVariant) {
        this.returnVariant = returnVariant;
    }

    public void setLineDirection(String lineDirection) {
        this.lineDirection = lineDirection;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return returnVariant == direction.returnVariant &&
                Objects.equals(lineDirection, direction.lineDirection) &&
                Objects.equals(lineName, direction.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnVariant, lineDirection, lineName);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "returnVariant=" + returnVariant +
                ", lineDirection='" + lineDirection + '\'' +
                ", lineName='" + lineName + '\'' +
                '}';
    }

}
