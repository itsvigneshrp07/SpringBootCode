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
@Table(name = "AGREEMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agreements {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;
	@Column(name = "SOURCE_SYSTEM_NAME")
	private String sourceSystemNumber;

	@Column(name = "LOAN_ACCOUNT_NUMBER")
	private String loanAccountNumber;

	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;

	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;

	@Column(name = "BRANCH_CODE")
	private String branchCode;

	@Column(name = "PORTFOLIO_CODE")
	private String portfolioCode;

	@Column(name = "LOAN_TYPE")
	private String loanType;

	@Column(name = "SCHEME_CODE")
	private String schemeCode;

	@Column(name = "APPLICATION_REFERENCE_ID")
	private String applicationReferenceId;

	@Column(name = "SALES_PERSON")
	private String salesPerson;

	@Column(name = "DEALER_CODE")
	private String dealerCode;

	@Column(name = "DEALER_SALES_PERSON")
	private String dealerSalesPerson;

	@Column(name = "REPAYMENT_FREQUENCY")
	private String repaymentFrequency;

	@Column(name = "PAYMENT_TYPE")
	private String paymentType;

	@Column(name = "DISBURSEMENT_DATE")
	private Date disbursementDate;

	@Column(name = "LOAN_STARTDATE")
	private Date loanStartDate;

	@Column(name = "LOAN_ENDDATE")
	private Date loanEndDate;

	@Column(name = "TENOR")
	private Integer tenor;

	@Column(name = "CYCLE_DAY")
	private Integer cycleDay;

	@Column(name = "GRACE_DAYS")
	private Integer graceDays;

	@Column(name = "SANCTION_AMOUNT")
	private Integer sanctionAmount;

	@Column(name = "LOAN_AMOUNT")
	private Integer loanAmount;

	@Column(name = "INTEREST_RATE_TYPE")
	private String interestRateType;

	@Column(name = "PLR")
	private String plr;

	@Column(name = "MARGINS")
	private Integer margins;

	@Column(name = "ACTUAL_INTEREST_RATE")
	private Integer actualInterestRate;

	@Column(name = "INSTALLMENT_AMOUNT")
	private Integer installmentAmount;

	@Column(name = "DOWN_PAYMENT")
	private Integer downPayment;

	@Column(name = "DOWN_PAYMENT_PERCENTAGE")
	private Integer downPaymentPercentage;

	@Column(name = "BUCKET_CODE")
	private String bucketCode;

	@Column(name = "NEXT_DUE_DATE")
	private Date nextDueDate;

	@Column(name = "OD_DAYS")
	private Integer odDays;

	@Column(name = "EXCESS_AMOUNT")
	private Integer excessAmount;

	@Column(name = "LAST_AMOUNT_PAID")
	private Integer lastAmountPaid;

	@Column(name = "LAST_PAYMENT_DATE")
	private Date lastPaymentDate;

	@Column(name = "OD_AMOUNT")
	private Integer odAmount;

	@Column(name = "OS_AMOUNT")
	private Integer osAmount;

	@Column(name = "WRITE_OFF_FLAG")
	private String writeOffFlag;

	@Column(name = "WRITE_OFF_AMOUNT")
	private Integer writeOffAmount;

	@Column(name = "WRITE_OFF_DATE")
	private Date writeOffDate;

	@Column(name = "WRITE_OFF_REASON1")
	private String writeOffReason1;

	@Column(name = "DELINQUENCY_STARTDATE")
	private Date delinquencyStartDate;

	@Column(name = "NON_STARTER_FLAG")
	private String nonStarterFlag;

	@Column(name = "OS_PRIN_AMOUNT")
	private Integer osPrinAmount;

	@Column(name = "OD_PRIN_AMOUNT")
	private Integer odPrinAmount;

	@Column(name = "REPOFLAG")
	private String repoflag;

	@Column(name = "Loan_Restructured_YN")
	private String loanRestructuredYN;

	@Column(name = "Restructured_Scheme")
	private String restructuredScheme;

	@Column(name = "MORAT_APPLIED")
	private String moratApplied;

	@Column(name = "MORAT_PERIOD")
	private String moratPeriod;

	@Column(name = "PSL_CATEGORY")
	private String pslCategory;

	@Column(name = "PSL_SECTOR")
	private String pslSector;

	@Column(name = "PSL_SUB_CATEGORY")
	private String pslSubCategory;

	@Column(name = "PSL_Investment_IN_Plant_Machinary")
	private String pslInvestmentInPlantMachinary;

	@Column(name = "PSL_Weeker_Section")
	private String pslWeekerSection;

	@Column(name = "PSL_Purpose")
	private String pslPurpose;

	@Column(name = "GSTN_Number")
	private String gstnNumber;

	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	private Date upatatedDate;

}
