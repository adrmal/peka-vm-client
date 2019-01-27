package com.github.adrmal.peka.vm.client;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;

public class PekaDateTimeAdapter extends TypeAdapter<LocalDateTime> {

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        // not implemented, because not needed
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        String dateAsString = in.nextString();
        return LocalDateTime.parse(dateAsString.replace("Z", ""));
    }

}
