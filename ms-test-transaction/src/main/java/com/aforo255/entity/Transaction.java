package com.aforo255.entity;

import java.time.LocalDateTime;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "transaction")
public class Transaction {

	
	@BsonId
	private String id ; 
	
	private int invoiceId;
	
	private double amount ;
	
	private LocalDateTime date;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	
	
}
