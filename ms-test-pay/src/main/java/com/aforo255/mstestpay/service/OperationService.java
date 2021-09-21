package com.aforo255.mstestpay.service;

import com.aforo255.mstestpay.dto.OperationDto;
import com.aforo255.mstestpay.dto.OperationRequestDto;

public interface OperationService {

  OperationDto saveOperation(OperationRequestDto operationDto);
}
