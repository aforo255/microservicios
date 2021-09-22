package com.aforo255.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.entity.Transaction;
import com.aforo255.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	private TransactionRepository tRepo;
	
	@Override
	public Transaction save(Transaction transaction) {		
		return tRepo.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByInvoiceId(Integer idInvoice) {
		
		return tRepo.findByInvoicetId(idInvoice);
	}

	@Override
	public Iterable<Transaction> findAll() {
		return tRepo.findAll();
	}
	
	
	
	

}
