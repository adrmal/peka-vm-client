package com.github.adrmal.peka.vm.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Direction {

    private boolean returnVariant;
    @SerializedName("direction")
    private String lineFinalStop;
    private String lineName;

    public Direction() {
        // nop
    }

    public Direction(boolean returnVariant, String lineFinalStop, String lineName) {
        this.returnVariant = returnVariant;
        this.lineFinalStop = lineFinalStop;
        this.lineName = lineName;
    }

    public boolean isReturnVariant() {
        return returnVariant;
    }

    public String getLineFinalStop() {
        return lineFinalStop;
    }

    public String getLineName() {
        return lineName;
    }

    public void setReturnVariant(boolean returnVariant) {
        this.returnVariant = returnVariant;
    }

    public void setLineFinalStop(String lineFinalStop) {
        this.lineFinalStop = lineFinalStop;
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
                Objects.equals(lineFinalStop, direction.lineFinalStop) &&
                Objects.equals(lineName, direction.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnVariant, lineFinalStop, lineName);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "returnVariant=" + returnVariant +
                ", lineDirection='" + lineFinalStop + '\'' +
                ", lineName='" + lineName + '\'' +
                '}';
    }

}
