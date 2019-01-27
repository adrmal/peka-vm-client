package com.github.adrmal.peka.vm.client;

import com.github.adrmal.peka.vm.client.model.*;

import java.io.IOException;
import java.util.List;

public class Peka {

	private static PekaRequestExecutor requestExecutor = new PekaRequestExecutor();

	private Peka() {
	    // nop
    }

	public static List<StopPoint> getStopPoints(String stopPointPattern) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getStopPoints")
				.withParam("pattern", stopPointPattern)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseStopPoints(json);
	}

	public static List<Bollard> getBollardsByStopPoint(String stopPointName) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getBollardsByStopPoint")
				.withParam("name", stopPointName)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseBollards(json);
	}

	public static List<Bollard> getBollardsByStreet(String streetName) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getBollardsByStreet")
				.withParam("name", streetName)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseBollards(json);
	}

	public static List<DirectionWithBollards> getDirectionsWithBollardsByLine(String lineNumber) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getBollardsByLine")
				.withParam("name", lineNumber)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseDirectionsWithBollards(json);
	}

	public static List<Line> getLines(String linePattern) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getLines")
				.withParam("pattern", linePattern)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseLines(json);
	}

	public static List<Street> getStreets(String streetPattern) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getStreets")
				.withParam("pattern", streetPattern)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseStreets(json);
	}

	public static List<DepartureTime> getTimesByBollard(String bollardTag) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getTimes")
				.withParam("symbol", bollardTag)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseDepartureTimesForOneBollard(json);
	}

	public static List<DepartureTime> getTimesByStopPoint(String stopPointName) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getTimesForAllBollards")
				.withParam("name", stopPointName)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseDepartureTimesForManyBollards(json);
	}

	public static long getServerTime() throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("getServerTime")
				.withEmptyParam()
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseServerTime(json);
	}

	public static List<Message> getMessagesForBollard(String bollardTag) throws IOException {
		PekaRequest request = PekaRequestBuilder.builder()
				.withMethod("findMessagesForBollard")
				.withParam("symbol", bollardTag)
				.build();

		String json = tryExecute(request);
		return PekaJsonParser.parseMessages(json);
	}

	private static String tryExecute(PekaRequest request) throws IOException {
		try {
			return requestExecutor.execute(request);
		}
		catch(Exception e) {
			throw new IOException("Internet connection error.");
		}
	}

}
