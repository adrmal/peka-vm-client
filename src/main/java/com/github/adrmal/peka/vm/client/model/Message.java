package com.github.adrmal.peka.vm.client.model;

import com.github.adrmal.peka.vm.client.PekaDateTimeAdapter;
import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private String content;
    @JsonAdapter(PekaDateTimeAdapter.class)
    private LocalDateTime startDate;
    @JsonAdapter(PekaDateTimeAdapter.class)
    private LocalDateTime endDate;

    public Message() {
        // nop
    }

    public Message(String content, LocalDateTime startDate, LocalDateTime endDate) {
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(content, message.content) &&
                Objects.equals(startDate, message.startDate) &&
                Objects.equals(endDate, message.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
