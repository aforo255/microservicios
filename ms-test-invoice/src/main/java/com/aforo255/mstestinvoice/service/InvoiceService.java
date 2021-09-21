package com.aforo255.mstestinvoice.service;

import com.aforo255.mstestinvoice.dto.InvoiceDto;
import com.aforo255.mstestinvoice.dto.InvoiceStateDto;
import java.util.List;

public interface InvoiceService {

  List<InvoiceDto> findAll();

  InvoiceDto foundInvoice(Long id);

  InvoiceDto save(InvoiceDto invoiceDto);

  InvoiceStateDto foundInvoiceState(Integer id);
}
