package com.aforo255.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aforo255.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

	
	@Query("{'invoiceId':?0}")
	public Iterable<Transaction> findByInvoicetId(Integer id_invoice);
}
