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
@Table(name = "UCIC_MASTER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UcicMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	@Column(name="SourceSystemName")
    private String sourceSystemName;
	@Column(name="ApplicationNumber")
    private String applicationNumber;
	
	@Column(name="LoanAccountNumber")
    private String loanAccountNumber;
	@Column(name="CustomerNumber")
    private String customerNumber;
	@Column(name="AccountStatus")
    private String accountStatus;

	@Column(name="Ucic")
    private String ucic;

	@Column(name="Gucic")
    private String gucic;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	

	
}
