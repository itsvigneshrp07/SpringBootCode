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
@Table(name = "APPLICATION_LEADS")
public class ApplicationLeads implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LEAD_SORCE_NAME")
	private String leadSourceName;

	@Column(name = "APPLICATION_REFERNECE_ID")
	private String applicationReferenceId;

	@Column(name = "APPLICATION_DATE")
	private Date applicationDate;

	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@Column(name = "LEAD_STATUS")
	private String leadStatus;

	@Column(name = "PARTNER_NAME")
	private String partnerName;

	@Column(name = "DSA_NAME")
	private String dsaName;

	@Column(name = "RM_NAME")
	private String rmName;

	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdateDate;

	@Column(name = "LAST_UPDATED_STATUS")
	private String lastUpdateStatus;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private int lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date upatatedDate;

}
