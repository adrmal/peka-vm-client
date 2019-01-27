package com.github.adrmal.peka.vm.client.model;

import java.util.List;
import java.util.Objects;

public class DirectionWithBollards {

    private Direction direction;
    private List<Bollard> bollards;

    public DirectionWithBollards() {
        // nop
    }

    public DirectionWithBollards(Direction direction, List<Bollard> bollards) {
        this.direction = direction;
        this.bollards = bollards;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Bollard> getBollards() {
        return bollards;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setBollards(List<Bollard> bollards) {
        this.bollards = bollards;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DirectionWithBollards that = (DirectionWithBollards) o;
        return Objects.equals(direction, that.direction) &&
                Objects.equals(bollards, that.bollards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, bollards);
    }

    @Override
    public String toString() {
        return "DirectionWithBollards{" +
                "direction=" + direction +
                ", bollards=" + bollards +
                '}';
    }

}
