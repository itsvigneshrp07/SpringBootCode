package com.st.mdm.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "FIN_DETAILS")
public class FinDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LOAN_ACCOUNT_NUMBER")
	private String loanAccountNumber;

	@Column(name = "PAYMENT_REFERENCE_NUMBER")
	private Integer paymentReferenceNumber;

	@Column(name = "PAYMENT_POSTING_DATE")
	private Date paymentPostingDate;

	@Column(name = "VALUE_DATE")
	private Date valueDate;

	@Column(name = "TRANSACTION_CODE")
	private String transactionCode;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@Column(name = "PAYMENT_AMOUNT")
	private Integer paymentAmount;

	@Column(name = "NARRATION")
	private String narration;

	@Column(name = "DEBIT")
	private String debit;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TYPE_OF_INSTRUMENT")
	private String typeOfInstrument;

	@Column(name = "INSTRUMENT_DATE")
	private Date instrumentDate;

	@Column(name = "INSTRUMENT_NUMBER")
	private Integer instrumentNumber;

	@Column(name = "DEPOSIT_DATE")
	private Date depositDate;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "RECEIPT_NUMBER")
	private Integer receiptNumber;

	@Column(name = "BOUNCEDATE")
	private Date bounceDate;

	@Column(name = "BOUNCEREASON")
	private String bounceReason;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private Integer lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date upatatedDate;

}
