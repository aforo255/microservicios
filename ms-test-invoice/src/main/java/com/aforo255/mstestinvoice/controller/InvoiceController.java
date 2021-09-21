package com.aforo255.mstestinvoice.controller;

import com.aforo255.mstestinvoice.dto.InvoiceDto;
import com.aforo255.mstestinvoice.service.InvoiceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/invoice")
@RequiredArgsConstructor
public class InvoiceController {

  private final InvoiceService invoiceService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<InvoiceDto>> findAll() {
    return ResponseEntity.ok(invoiceService.findAll());
  }

  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<InvoiceDto> foundInvoice(@PathVariable Long id) {
    return ResponseEntity.ok(invoiceService.foundInvoice(id));
  }

  @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<InvoiceDto> saveInvoice(@RequestBody InvoiceDto invoiceDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.save(invoiceDto));
  }

}
