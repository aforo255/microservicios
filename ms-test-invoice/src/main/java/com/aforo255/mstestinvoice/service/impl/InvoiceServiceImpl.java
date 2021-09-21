package com.aforo255.mstestinvoice.service.impl;

import com.aforo255.mstestinvoice.dto.InvoiceDto;
import com.aforo255.mstestinvoice.dto.InvoiceStateDto;
import com.aforo255.mstestinvoice.exception.InvoiceNotFoundException;
import com.aforo255.mstestinvoice.mapper.InvoiceMapper;
import com.aforo255.mstestinvoice.model.Invoice;
import com.aforo255.mstestinvoice.model.InvoiceState;
import com.aforo255.mstestinvoice.repository.InvoiceRepository;
import com.aforo255.mstestinvoice.repository.InvoiceStateRepository;
import com.aforo255.mstestinvoice.service.InvoiceService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

  private final InvoiceRepository invoiceRepository;
  private final InvoiceMapper invoiceMapper;
  private final InvoiceStateRepository invoiceStateRepository;

  @Override

  public List<InvoiceDto> findAll() {
    return invoiceRepository.findAll().stream()
        .map(invoiceMapper::toInvoiceDto)
        .collect(Collectors.toList());
  }

  @Override
  public InvoiceDto foundInvoice(Long id) {

    Invoice invoice = invoiceRepository.findById(id)
        .orElseThrow(() -> new InvoiceNotFoundException("Invoice Id " + id + " no se encuentra"));

    return invoiceMapper.toInvoiceDto(invoice);

  }

  @Override
  public InvoiceDto save(InvoiceDto invoiceDto) {
    return invoiceMapper.toInvoiceDto(invoiceRepository.save(invoiceMapper.toInvoice(invoiceDto)));
  }

  @Override
  public InvoiceStateDto foundInvoiceState(Integer id) {
    InvoiceState invoiceState = invoiceStateRepository.findById(id).orElseThrow(
        () -> new InvoiceNotFoundException("Invoice State Id " + id + " no se encuentra"));

    return invoiceMapper.toInvoiceStateDto(invoiceState);
  }

}
