package com.aforo255.mstestinvoice.mapper;

import com.aforo255.mstestinvoice.dto.InvoiceDto;
import com.aforo255.mstestinvoice.dto.InvoiceStateDto;
import com.aforo255.mstestinvoice.model.Invoice;
import com.aforo255.mstestinvoice.model.InvoiceState;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

  InvoiceDto toInvoiceDto(Invoice invoice);

  Invoice toInvoice(InvoiceDto invoiceDto);

  InvoiceStateDto toInvoiceStateDto(InvoiceState invoiceState);

}
