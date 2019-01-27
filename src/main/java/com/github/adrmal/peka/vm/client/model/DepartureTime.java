package com.github.adrmal.peka.vm.client.model;

import com.github.adrmal.peka.vm.client.PekaDateTimeAdapter;
import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDateTime;
import java.util.Objects;

public class DepartureTime {

    private Bollard bollard;
    private boolean realTime;
    private int minutes;
    private String direction;
    private boolean onStopPoint;
    @JsonAdapter(PekaDateTimeAdapter.class)
    private LocalDateTime departure;
    private String line;

    public DepartureTime() {
        // nop
    }

    public DepartureTime(Bollard bollard, boolean realTime, int minutes, String direction, boolean onStopPoint, LocalDateTime departure, String line) {
        this.bollard = bollard;
        this.realTime = realTime;
        this.minutes = minutes;
        this.direction = direction;
        this.onStopPoint = onStopPoint;
        this.departure = departure;
        this.line = line;
    }

    public Bollard getBollard() {
        return bollard;
    }

    public boolean isRealTime() {
        return realTime;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isOnStopPoint() {
        return onStopPoint;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public String getLine() {
        return line;
    }

    public void setBollard(Bollard bollard) {
        this.bollard = bollard;
    }

    public void setRealTime(boolean realTime) {
        this.realTime = realTime;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setOnStopPoint(boolean onStopPoint) {
        this.onStopPoint = onStopPoint;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DepartureTime that = (DepartureTime) o;
        return realTime == that.realTime &&
                minutes == that.minutes &&
                onStopPoint == that.onStopPoint &&
                Objects.equals(bollard, that.bollard) &&
                Objects.equals(direction, that.direction) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bollard, realTime, minutes, direction, onStopPoint, departure, line);
    }

    @Override
    public String toString() {
        return "DepartureTime{" +
                "bollard=" + bollard +
                ", realTime=" + realTime +
                ", minutes=" + minutes +
                ", direction='" + direction + '\'' +
                ", onStopPoint=" + onStopPoint +
                ", departure=" + departure +
                ", line='" + line + '\'' +
                '}';
    }

}
