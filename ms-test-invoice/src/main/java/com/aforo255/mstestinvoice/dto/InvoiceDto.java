package com.aforo255.mstestinvoice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

  private Long invoiceId;

  private BigDecimal amount;

  private InvoiceStateDto invoiceState;

  private CustomerDto customer;

}
