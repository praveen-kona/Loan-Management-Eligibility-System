# Loan Management & Eligibility System

## Java OOP Banking POC

A console-based Java application that simulates a simplified **bank loan eligibility and approval workflow**. The system supports **Personal Loan, Home Loan, Car Loan, and Gold Loan** and demonstrates practical usage of Core Java and Object-Oriented Programming concepts.

---

## Project Overview

The application collects customer information such as **salary, age, CIBIL score, phone number, Aadhaar number, and PAN details**. Based on loan-specific eligibility rules, it determines whether the customer is eligible for the selected loan.

After basic eligibility is satisfied, the application validates customer document formats using **Regular Expressions**. It then performs **CIBIL-based risk assessment** and calculates the final **Rate of Interest (ROI)** using a loan-specific base ROI and CIBIL-based adjustment.

If all validations are successful, the loan is approved and loan-specific document verification is performed.

---
### Technologies Used

Java | Core Java | OOP | Interfaces | Abstraction | Inheritance | Polymorphism | Method Overriding | Regular Expressions | Scanner

---

## Loan Types

| Loan Type | Minimum Salary | Minimum Age | Base ROI |
|---|---:|---:|---:|
| Personal Loan | ₹9,00,000 | 26 | 8.5% |
| Home Loan | ₹8,00,000 | 25 | 6.5% |
| Car Loan | ₹5,00,000 | 23 | 7.5% |
| Gold Loan | ₹5,00,000 | 23 | 8.5% |

*CIBIL must be between 300 and 900 for eligibility.*

---
 
## Architecture

```text
                    Loan Interface
                          |
                     implements
                          |
                       LoanImpl
                          |
        +-----------------+------------------+
        |          |             |           |
        v          v             v           v
 PersonalLoan  HomeLoan       CarLoan     GoldLoan
 ```

### Design Approach

- `Loan` defines the common loan operations.
- `LoanImpl` provides reusable implementations such as customer input and document validation.
- Individual loan classes extend `LoanImpl`.
- Each loan class provides its own eligibility rules, base ROI, ROI calculation, and document verification.
- Method overriding allows different loan types to implement their own ROI behavior.

---

## Project Structure

```text
LoanManagementEligibilitySystem/
│
├── src/
│   └── projects/
│       ├── Loan.java
│       ├── LoanImpl.java
│       ├── PersonalLoan.java
│       ├── HomeLoan.java
│       ├── CarLoan.java
│       └── GoldLoan.java
│
└── README.md
```
## CIBIL Risk Assessment

The system performs a simplified CIBIL-based risk assessment before calculating the final loan ROI.

| CIBIL Score | Risk Category | ROI Adjustment |
|---:|---|---:|
| 300–549 | High Risk | +4.0% |
| 550–699 | Moderate Risk | +2.0% |
| 700–749 | Low Risk | +1.5% |
| 750–900 | Very Low Risk | +0.5% |

The CIBIL score is also checked during the initial eligibility validation to ensure that it falls within the accepted range of **300–900**.

This demonstrates a simplified **credit-risk assessment and risk-based pricing approach** used in loan processing.

---

## ROI Calculation

Each loan type has its own **base ROI**:

| Loan Type | Base ROI |
|---|---:|
| Personal Loan | 8.5% |
| Home Loan | 6.5% |
| Car Loan | 7.5% |
| Gold Loan | 8.5% |

The final ROI is calculated using:

```text
Final ROI = Base ROI + CIBIL Risk Adjustment
Base ROI          = 7.5%
CIBIL Risk        = Very Low Risk
CIBIL Adjustment  = +0.5%

Final ROI         = 7.5% + 0.5%
                  = 8.0%
```
## Validation

The application performs multiple levels of validation before approving a loan.

### Customer Eligibility Validation

The system validates:

- Minimum salary requirement
- Minimum age requirement
- CIBIL score between 300 and 900

Each loan type has its own salary and age eligibility criteria.

### Document Validation

The application validates:

- Phone number
- Aadhaar number
- PAN number

Regular Expressions (Regex) are used to validate the expected input format.

### PAN Validation Example

```java
pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
```

### Phone Validation Example
```java
phone.matches("[6-9]{1}[0-9]{9}");
```

### Application Flow
```java
                  Customer
                       |
                       v
                Enter Loan Details
                       |
                       v
          Salary + Age + CIBIL Validation
                       |
                       v
                Eligibility Check
                       |
             +---------+---------+
             |                   |
          Eligible            Not Eligible
             |                   |
             v                   v
      Document Validation     Loan Rejected
             |
             v
    Phone + Aadhaar + PAN
             |
             v
       CIBIL Risk Assessment
             |
             v
        ROI Calculation
             |
             v
      Loan Approval Decision
             |
             v
   Loan-Specific Document Check
             |
             v
       Loan Approved

```
### Real-World Mapping
This POC represents a simplified version of a banking loan-processing workflow.
```java
Project Feature	Real-World Concept
Salary & Age Check	Customer eligibility
CIBIL Validation	Credit eligibility
CIBIL Risk Assessment	Credit risk evaluation
Base ROI	Starting lending rate
ROI Adjustment	Risk-based pricing
PAN/Aadhaar Validation	KYC/Document Validation
Approval/Rejection	Loan Decision
Document Verification	Loan Processing

```

