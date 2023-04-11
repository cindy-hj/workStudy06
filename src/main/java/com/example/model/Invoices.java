package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceId;
	
	private String number;
	
	//FK clientId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	@JsonBackReference
	private Clients clientId;
	
	private String invoiceTotal;
	
	private String paymentTotal;
	
	private LocalDateTime invoiceDate;
	
	private LocalDateTime dueDate;
	
	private LocalDateTime paymentDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "invoiceId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payments> payments;
}
