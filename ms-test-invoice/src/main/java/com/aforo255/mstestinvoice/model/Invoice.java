package com.aforo255.mstestinvoice.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_invoice")
  private Long invoiceId;

  @Column(name = "amount")
  private BigDecimal amount;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private InvoiceState invoiceState;

  @ManyToOne
  @JoinColumn(name = "cutomer_id")
  private Customer customer;

}
