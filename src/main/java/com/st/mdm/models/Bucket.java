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

@Entity
@Table(name = "EM")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Bucket  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;

	@Column(name = "EMAIL_TYPE")
	private String emailType;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PRIOIRTY")
	private String prioirty;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private Integer lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
