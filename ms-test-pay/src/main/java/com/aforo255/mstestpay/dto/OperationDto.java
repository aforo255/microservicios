package com.aforo255.mstestpay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {

  private Long operationId;
  private Long invoiceId;
  private BigDecimal amount;
  private LocalDateTime date;

}
