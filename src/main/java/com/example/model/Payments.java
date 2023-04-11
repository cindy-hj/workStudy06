package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	// FK clientId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	@JsonBackReference
	private Clients clientId;
	
	// FK invoiceId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	@JsonBackReference
	private Invoices invoiceId;
	
	private LocalDateTime date;
	
	private String amount;
	
	// FK paymentMethod
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="payment_method_id")
	@JsonBackReference
	private PaymentMethods paymentMethodId;
}
