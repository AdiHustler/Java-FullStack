package com.prac;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prescreption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String medicines;
	private String dosage;
	private LocalDate issuedDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	
	public boolean isActive() {
		return issuedDate != null && issuedDate.isAfter(LocalDate.now().minusDays(30));
	}
}
