package com.github.adrmal.peka.vm.client;

import com.github.adrmal.peka.vm.client.model.*;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class PekaJsonParser {

	private static Gson gson = new Gson();
	private static JsonParser parser = new JsonParser();

	static List<StopPoint> parseStopPoints(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		List<StopPoint> stopPoints = new ArrayList<>();
		object.getAsJsonArray("success").forEach(element -> {
			String stopPointAsString = element.getAsJsonObject().toString();

			StopPoint stopPoint = fromJson(stopPointAsString, StopPoint.class);
			stopPoints.add(stopPoint);
		});

		return stopPoints;
	}

	static List<DepartureTime> parseDepartureTimesForOneBollard(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		String bollardAsString = object.getAsJsonObject("success").getAsJsonObject("bollard").toString();
		Bollard bollard = fromJson(bollardAsString, Bollard.class);

        List<DepartureTime> departureTimes = new ArrayList<>();
		object.getAsJsonObject("success").getAsJsonArray("times").forEach(element -> {
			String departureTimeAsString = element.getAsJsonObject().toString();

			DepartureTime departureTime = fromJson(departureTimeAsString, DepartureTime.class);
			departureTime.setBollard(bollard);
			departureTimes.add(departureTime);
		});

		return departureTimes;
	}

    static List<DepartureTime> parseDepartureTimesForManyBollards(String json) {
        JsonObject object = parser.parse(json).getAsJsonObject();

        List<DepartureTime> departureTimes = new ArrayList<>();
        object.getAsJsonObject("success").getAsJsonArray("bollardsWithTimes").forEach(element -> {
            String bollardAsString = element.getAsJsonObject().getAsJsonObject("bollard").toString();
            Bollard bollard = fromJson(bollardAsString, Bollard.class);

            element.getAsJsonObject().getAsJsonArray("times").forEach(e -> {
                String departureTimeAsString = e.getAsJsonObject().toString();

                DepartureTime departureTime = fromJson(departureTimeAsString, DepartureTime.class);
                departureTime.setBollard(bollard);
                departureTimes.add(departureTime);
            });
        });

        return departureTimes;
    }

	static List<Bollard> parseBollards(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		List<Bollard> bollards = new ArrayList<>();
		object.getAsJsonObject("success").getAsJsonArray("bollards").forEach(element -> {
			String directionsAsString = element.getAsJsonObject().getAsJsonArray("directions").toString();
			String bollardAsString = element.getAsJsonObject().getAsJsonObject("bollard").toString();

			Direction[] directions = fromJson(directionsAsString, Direction[].class);
			Bollard bollard = fromJson(bollardAsString, Bollard.class);
			bollard.setDirections(newArrayList(directions));
			bollards.add(bollard);
		});

		return bollards;
	}

	static List<DirectionWithBollards> parseDirectionsWithBollards(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		String directionsWithBollardsAsString = object.getAsJsonObject("success").getAsJsonArray("directions").toString();
		DirectionWithBollards[] directionsWithBollards = fromJson(directionsWithBollardsAsString, DirectionWithBollards[].class);
		return newArrayList(directionsWithBollards);
	}

	static List<Line> parseLines(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		List<Line> lines = new ArrayList<>();
		object.getAsJsonArray("success").forEach(element -> {
			String lineAsString = element.getAsJsonObject().toString();

			Line line = fromJson(lineAsString, Line.class);
			lines.add(line);
		});

		return lines;
	}

	static List<Street> parseStreets(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		List<Street> streets = new ArrayList<>();
		object.getAsJsonArray("success").forEach(element -> {
			String streetAsString = element.getAsJsonObject().toString();

			Street street = fromJson(streetAsString, Street.class);
			streets.add(street);
		});

		return streets;
	}

	static long parseServerTime(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		return object.getAsJsonPrimitive("success").getAsLong();
	}

	static List<Message> parseMessages(String json) {
		JsonObject object = parser.parse(json).getAsJsonObject();

		List<Message> messages = new ArrayList<>();
		object.getAsJsonArray("success").forEach(element -> {
			String messageAsString = element.getAsJsonObject().toString();

			Message message = fromJson(messageAsString, Message.class);
			messages.add(message);
		});

		return messages;
	}

	private static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

}
