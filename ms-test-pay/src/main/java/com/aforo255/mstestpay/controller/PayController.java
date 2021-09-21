package com.aforo255.mstestpay.controller;

import com.aforo255.mstestpay.dto.OperationDto;
import com.aforo255.mstestpay.dto.OperationRequestDto;
import com.aforo255.mstestpay.producer.PayEventProducer;
import com.aforo255.mstestpay.service.OperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pay")
@RequiredArgsConstructor
public class PayController {

  private final OperationService operationService;
  private final PayEventProducer payEventProducer;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OperationDto> payInvoice(@RequestBody OperationRequestDto request)
      throws JsonProcessingException {
    OperationDto operationDto = operationService.saveOperation(request);
    payEventProducer.sendPayEvent(operationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(operationDto);
  }

}
