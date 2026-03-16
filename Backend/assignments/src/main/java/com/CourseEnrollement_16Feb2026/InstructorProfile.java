package com.prac;
import javax.persistence.*;

@Entity
public class InstructorProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String officeRoom;
	private String phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOfficeRoom() {
		return officeRoom;
	}
	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
