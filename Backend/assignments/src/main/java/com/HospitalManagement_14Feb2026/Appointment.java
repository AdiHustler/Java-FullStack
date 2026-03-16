package com.prac;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime appointDate;
	private String reason;
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "prescription_id")
	private Prescreption prescreption;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(LocalDateTime appointDate) {
		this.appointDate = appointDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Prescreption getPrescreption() {
		return prescreption;
	}

	public void setPrescreption(Prescreption prescreption) {
		this.prescreption = prescreption;
	}
	
	
	
	
	
}
