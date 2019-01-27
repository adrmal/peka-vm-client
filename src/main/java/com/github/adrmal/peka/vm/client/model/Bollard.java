package com.github.adrmal.peka.vm.client.model;

import java.util.List;
import java.util.Objects;

public class Bollard {

    private String symbol;
    private String tag;
    private String name;
    private boolean mainBollard;
    private Integer orderNo;
    private List<Direction> directions;

    public Bollard() {
        // nop
    }

    public Bollard(String symbol, String tag, String name, boolean mainBollard, Integer orderNo, List<Direction> directions) {
        this.symbol = symbol;
        this.tag = tag;
        this.name = name;
        this.mainBollard = mainBollard;
        this.orderNo = orderNo;
        this.directions = directions;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public boolean isMainBollard() {
        return mainBollard;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainBollard(boolean mainBollard) {
        this.mainBollard = mainBollard;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Bollard bollard = (Bollard) o;
        return mainBollard == bollard.mainBollard &&
                Objects.equals(symbol, bollard.symbol) &&
                Objects.equals(tag, bollard.tag) &&
                Objects.equals(name, bollard.name) &&
                Objects.equals(orderNo, bollard.orderNo) &&
                Objects.equals(directions, bollard.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, tag, name, mainBollard, orderNo, directions);
    }

    @Override
    public String toString() {
        return "Bollard{" +
                "symbol='" + symbol + '\'' +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", mainBollard=" + mainBollard +
                ", orderNo=" + orderNo +
                ", directions=" + directions +
                '}';
    }

}
