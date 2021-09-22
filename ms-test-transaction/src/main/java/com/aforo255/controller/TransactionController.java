package com.aforo255.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.entity.Transaction;
import com.aforo255.service.ITransactionService;

@RestController
public class TransactionController {

	@Autowired
	ITransactionService _transaction ;	
	
	@GetMapping("listar")	
	public List<Transaction> listar (){
		
		return ( List<Transaction>)_transaction.findAll();
	}
	
	@GetMapping ("/transaction/{idInvoice}")
	public ResponseEntity<?> getByInvoiceId (@PathVariable Integer idInvoice){
		
		Iterable< Transaction> transaction= _transaction.findByInvoiceId(idInvoice);
		return ResponseEntity.ok(transaction);
	}	
}
