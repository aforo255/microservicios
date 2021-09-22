package com.aforo255.entity;

import java.time.LocalDateTime;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "transaction")
public class Transaction {

	
	@BsonId
	private String id_transaccion ; 
	
	private int id_invoice;
	
	private double amount ;
	
	private LocalDateTime date;

	
	public String getId_transaccion() {
		return id_transaccion;
	}
	public void setId_transaccion(String id_transaccion) {
		this.id_transaccion = id_transaccion;
	}
	public int getId_invoice() {
		return id_invoice;
	}
	public void setId_invoice(int id_invoice) {
		this.id_invoice = id_invoice;
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
