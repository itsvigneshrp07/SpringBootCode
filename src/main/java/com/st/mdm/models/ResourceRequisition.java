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
@Table(name = "RESOURCE_REQUISITION")
public class ResourceRequisition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "RR_FUNCTION")
	private String function;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "NO_OF_REQUIREMENTS")
	private Integer noOfRequirements;

	@Column(name = "EXISTING_STAFF_AT_PRESENT")
	private String existingStaffAtPresent;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "TYPE_OF_APPOINTMENT")
	private String typeOfAppointment;

	@Column(name = "EDUCATIONAL_QUALIFICATION")
	private String educationalQualification;

	@Column(name = "SKILLS")
	private String skills;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "JOB_DESCRIPTION")
	private String jobDescription;

	@Column(name = "TENTATIVE_DATE_OF_JOINING")
	private Date tentativeDateofJoining;

	@Column(name = "VACANCY_CAUSED_DUETO")
	private String vacancyCausedDueTo;

	@Column(name = "INTERNAL_TRASFER")
	private String internalTransfer;

	@Column(name = "SALARY_RANGE")
	private String salaryRange;

	@Column(name = "PRIORITY_LEVEL")
	private String priorityLevel;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private Integer lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
