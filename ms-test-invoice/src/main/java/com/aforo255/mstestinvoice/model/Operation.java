package com.aforo255.mstestinvoice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Operation {

  private Long operationId;

  private Long invoiceId;

  private BigDecimal amount;

  private LocalDateTime date;

}
