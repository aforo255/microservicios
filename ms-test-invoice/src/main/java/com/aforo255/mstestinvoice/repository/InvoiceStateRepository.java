package com.aforo255.mstestinvoice.repository;

import com.aforo255.mstestinvoice.model.InvoiceState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceStateRepository extends JpaRepository<InvoiceState, Integer> {

}
