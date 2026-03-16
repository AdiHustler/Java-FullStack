package com.prac;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate recordDate;
	private String diagnosis;
	private String notes;
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public LocalDate getRecordDate() {
		return recordDate;
	}



	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}



	public String getDiagnosis() {
		return diagnosis;
	}



	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public String getSummary() {
		return id + " -> "+recordDate+" -> "+diagnosis+" -> "+notes;
	}
}
