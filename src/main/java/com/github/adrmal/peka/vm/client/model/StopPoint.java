package com.github.adrmal.peka.vm.client.model;

import java.util.Objects;

public class StopPoint {

	private String symbol;
	private String name;

	public StopPoint() {
		// nop
	}

	public StopPoint(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		StopPoint stopPoint = (StopPoint) o;
		return Objects.equals(symbol, stopPoint.symbol) &&
				Objects.equals(name, stopPoint.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol, name);
	}

	@Override
	public String toString() {
		return "StopPoint{" +
				"symbol='" + symbol + '\'' +
				", name='" + name + '\'' +
				'}';
	}

}
