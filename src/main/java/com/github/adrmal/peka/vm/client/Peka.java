package com.github.adrmal.peka.vm.client;

import com.github.adrmal.peka.vm.client.model.*;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class Peka {

	private static PekaRequestExecutor requestExecutor = new PekaRequestExecutor();

	private Peka() {
	    // nop
    }

	public static List<StopPoint> getStopPoints(String stopPointPattern) throws IOException {
		return executeAndParseRequest(
				"getStopPoints",
				"pattern",
				stopPointPattern,
				PekaJsonParser::parseStopPoints
		);
	}

	public static List<Bollard> getBollardsByStopPoint(String stopPointName) throws IOException {
		return executeAndParseRequest(
				"getBollardsByStopPoint",
				"name",
				stopPointName,
				PekaJsonParser::parseBollards
		);
	}

	public static List<Bollard> getBollardsByStreet(String streetName) throws IOException {
		return executeAndParseRequest(
				"getBollardsByStreet",
				"name",
				streetName,
				PekaJsonParser::parseBollards
		);
	}

	public static List<DirectionWithBollards> getDirectionsWithBollardsByLine(String lineNumber) throws IOException {
		return executeAndParseRequest(
				"getBollardsByLine",
				"name",
				lineNumber,
				PekaJsonParser::parseDirectionsWithBollards
		);
	}

	public static List<Line> getLines(String linePattern) throws IOException {
		return executeAndParseRequest(
				"getLines",
				"pattern",
				linePattern,
				PekaJsonParser::parseLines
		);
	}

	public static List<Street> getStreets(String streetPattern) throws IOException {
		return executeAndParseRequest(
				"getStreets",
				"pattern",
				streetPattern,
				PekaJsonParser::parseStreets
		);
	}

	public static List<DepartureTime> getTimesByBollard(String bollardTag) throws IOException {
		return executeAndParseRequest(
				"getTimes",
				"symbol",
				bollardTag,
				PekaJsonParser::parseDepartureTimesForOneBollard
		);
	}

	public static List<DepartureTime> getTimesByStopPoint(String stopPointName) throws IOException {
		return executeAndParseRequest(
				"getTimesForAllBollards",
				"name",
				stopPointName,
				PekaJsonParser::parseDepartureTimesForManyBollards
		);
	}

	public static long getServerTime() throws IOException {
		return executeAndParseRequest(
				"getServerTime",
				PekaJsonParser::parseServerTime
		);
	}

	public static List<Message> getMessagesForBollard(String bollardTag) throws IOException {
		return executeAndParseRequest(
				"findMessagesForBollard",
				"symbol",
				bollardTag,
				PekaJsonParser::parseMessages
		);
	}

	private static <R> R executeAndParseRequest(String methodName, String paramName, String paramValue, Function<String, R> jsonParseFunction) throws IOException {
		if(paramName != null && paramValue == null) {
			throw new IllegalArgumentException("Passed argument cannot be null.");
		}

		PekaRequest request = buildRequest(methodName, paramName, paramValue);
		String json = tryExecute(request);
		return tryParse(json, jsonParseFunction);
	}

	private static <R> R executeAndParseRequest(String methodName, Function<String, R> jsonParseFunction) throws IOException {
		return executeAndParseRequest(methodName, null, null, jsonParseFunction);
	}

	private static PekaRequest buildRequest(String methodName, String paramName, String paramValue) {
		PekaRequestBuilder requestBuilder = PekaRequestBuilder.builder();
		if(paramName == null) {
			return requestBuilder
					.withMethod(methodName)
					.withEmptyParam()
					.build();
		}
		else {
			return requestBuilder
					.withMethod(methodName)
					.withParam(paramName, paramValue)
					.build();
		}
	}

	private static String tryExecute(PekaRequest request) throws IOException {
		try {
			return requestExecutor.execute(request);
		}
		catch(Exception e) {
			throw new IOException("Internet connection error.");
		}
	}

	private static <R> R tryParse(String json, Function<String, R> jsonParseFunction) {
		try {
			return jsonParseFunction.apply(json);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Passed argument is incorrect.");
		}
	}

}
