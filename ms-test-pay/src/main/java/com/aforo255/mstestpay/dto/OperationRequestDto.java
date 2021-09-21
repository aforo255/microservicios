package com.aforo255.mstestpay.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequestDto {

  private Long invoiceId;
  private BigDecimal amount;


}
