package com.aforo255.mstestpay.mapper;

import com.aforo255.mstestpay.dto.OperationDto;
import com.aforo255.mstestpay.dto.OperationRequestDto;
import com.aforo255.mstestpay.model.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {java.time.LocalDateTime.class})
public interface OperationMapper {

  OperationDto toOperationDto(Operation operation);

  @Mapping(target = "date", expression = "java(LocalDateTime.now())")
  Operation toOperation(OperationRequestDto operationRequestDto);

}
