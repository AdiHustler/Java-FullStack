package com.CrmAssesment;
import javax.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue
    private Long ticketId;

    private String issue;
    private String status;
    
    

    public SupportTicket() {
		this.ticketId = ticketId;
		this.issue = issue;
		this.status = status;
	}

	@OneToOne
    private Order order;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

    
}