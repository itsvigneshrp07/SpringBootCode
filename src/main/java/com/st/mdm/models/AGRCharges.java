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
@Table(name = "AGRCHARGES")
public class AGRCharges implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LOAN_ACCOUNT_NUMBER")
	private String loanAccountNumber;

	@Column(name = "PAYMENT_HEAD")
	private String paymentHead;

	@Column(name = "OUTSTANDING_AMOUNT")
	private Integer outstandingAmount;

	@Column(name = "AMOUNT_PAID_TILL_NOW")
	private Integer amountPaidTillNow;

	@Column(name = "AMOUNT_WAIVED_TILL_NOW")
	private Integer amountWaivedTillNow;

	@Column(name = "ORDERDUE_AMOUNT")
	private Integer orderDueAmount;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private Integer lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date upatatedDate;

}
