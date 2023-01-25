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
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COMPANY_CODE")
	private String companyCode;

	@Column(name = "SOURCE_SYSTEM_NAME")
	private String sourceSystemName;

	@Column(name = "CONTACTADDRESS_TYPE")
	private String contactAddressType;

	@Column(name = "MAILING_ADDRESS_TYPE")
	private String mailingAddressType;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "GROUP_ID")
	private String groupID;

	@Column(name = "GROUP_NAME")
	private String groupName;

	@Column(name = "CUSTOMER_TYPE")
	private String customerType;

	@Column(name = "CUSTOMER_CATEGORY")
	private String customerCategory;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;

	@Column(name = "FATHER_NAME")
	private String fatherName;

	@Column(name = "MOTHER_NAME")
	private String motherName;

	@Column(name = "PAN_NUMBER")
	private String panNumber;

	@Column(name = "AADHAAR_NUMBER")
	private String aadhaarNumber;

	@Column(name = "PASSPORT_NUMBER")
	private String passportNumber;

	@Column(name = "DRIVING_LICENSE_NUMBER")
	private String drivingLicenseNumber;

	@Column(name = "OTHER_IDENTITY_CARD_NUMBER")
	private String identityCardNumber;

	@Column(name = "OCCUPATION_TYPE")
	private String occupationType;

	@Column(name = "EMPLOYER_NAME")
	private String employerName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "YEARS_OF_EMPLOYMENT")
	private Integer yearsOfEmployment;

	@Column(name = "INDUSTRY_NAME")
	private String industryName;

	@Column(name = "ANNUAL_INCOME")
	private Integer annualIncome;

	@Column(name = "FAMILY_INCOME")
	private Integer familyIncome;

	@Column(name = "BANK_ACCOUNT_NUMBER")
	private String bankAccountNumber;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BANK_IFSC")
	private String Ifsc;

	@Column(name = "BANK_MICR")
	private String Micr;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "CONTACT_PERSON")
	private String contactPerson;

	@Column(name = "CUSTOMER_RISK_CATEGORY")
	private String customerRiskCategory;

	@Column(name = "CUSTOMER_SEGMENT")
	private String customerSegment;

	@Column(name = "CIN")
	private String cin;

	@Column(name = "GSTIN")
	private String gstin;

	@Column(name = "TAN")
	private String tan;

	@Column(name = "LOCKED", columnDefinition = "integer default 0")
	private int lock;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date upatatedDate;

}
