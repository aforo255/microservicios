package com.aforo255.mstestpay.service.impl;

import com.aforo255.mstestpay.dto.OperationDto;
import com.aforo255.mstestpay.dto.OperationRequestDto;
import com.aforo255.mstestpay.mapper.OperationMapper;
import com.aforo255.mstestpay.repository.OperationRepository;
import com.aforo255.mstestpay.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

  private final OperationRepository operationRepository;
  private final OperationMapper operationMapper;

  @Override
  public OperationDto saveOperation(OperationRequestDto request) {
    return operationMapper.toOperationDto(
        operationRepository.save(operationMapper.toOperation(request)));
  }
}
