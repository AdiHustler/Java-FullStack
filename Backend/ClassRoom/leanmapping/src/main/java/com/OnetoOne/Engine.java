package com.OnetoOne;

import javax.persistence.*;


@Entity

public class Engine {

	

	@Id

	private int eid;

	private String type;

	private String fuelType;

	private double milege;

	private int cc;

	public int getId() {

		return eid;

	}

	public void setId(int id) {

		this.eid = id;

	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

	public String getFuelType() {

		return fuelType;

	}

	public void setFuelType(String fuelType) {

		this.fuelType = fuelType;

	}

	public double getMilege() {

		return milege;

	}

	public void setMilege(double milege) {

		this.milege = milege;

	}

	public int getCc() {

		return cc;

	}

	public void setCc(int cc) {

		this.cc = cc;

	}

	@Override

	public String toString() {

		return "Engine [id=" + eid + ", type=" + type + ", fuelType=" + fuelType + ", milege=" + milege + ", cc=" + cc

				+ "]";

	}
}