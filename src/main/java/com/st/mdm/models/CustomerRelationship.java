package com.st.mdm.models;

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

@Entity
@Table(name = "CUSTOMER_RELATIONSHIP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRelationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "LOAN_ACCOUNT_NUMBER")
	private String loanAccountNumber;

	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	@Column(name = "ROLE_ASSOCIATION")
	private String roleAssociation;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
