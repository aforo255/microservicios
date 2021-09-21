package com.aforo255.mstestinvoice.service;

import com.aforo255.mstestinvoice.dto.InvoiceDto;
import com.aforo255.mstestinvoice.model.Operation;
import com.aforo255.mstestinvoice.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationsEvents {

  private final InvoiceService invoiceService;
  private final ObjectMapper objectMapper;

  public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord)
      throws JsonProcessingException {

    Operation operation = objectMapper.readValue(consumerRecord.value(), Operation.class);
    InvoiceDto invoiceDto = invoiceService.foundInvoice(operation.getInvoiceId());

    Integer statusId = invoiceDto.getInvoiceState().getStatusId();

    if (Constants.PAID == statusId || Constants.REFUND == statusId) {
      log.info("La factura Id: {} ya esta pagada", invoiceDto.getInvoiceId());

    } else {

      if (invoiceDto.getAmount().compareTo(operation.getAmount()) == 0) {
        invoiceDto.setInvoiceState(invoiceService.foundInvoiceState(Constants.PAID));

      } else if (invoiceDto.getAmount().compareTo(operation.getAmount()) > 0) {
        invoiceDto.setInvoiceState(invoiceService.foundInvoiceState(Constants.NOT_PAID));

      } else if (invoiceDto.getAmount().compareTo(operation.getAmount()) < 0) {
        
        //se aplicará reembolso si es que el monto pagado supera el monto a pagar de la factura
        invoiceDto.setInvoiceState(invoiceService.foundInvoiceState(Constants.REFUND));
      }
      log.info("Actualizando pago de Factura Id: {} con estado: {} ", invoiceDto.getInvoiceId(),
          invoiceDto.getInvoiceState().getDescription());

      invoiceService.save(invoiceDto);
    }
  }


}
