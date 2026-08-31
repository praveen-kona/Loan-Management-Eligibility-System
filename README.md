# Loan Management & Eligibility System

## Java OOP Banking POC

A console-based Java application that simulates a simplified **bank loan eligibility and approval workflow**. The system supports **Personal Loan, Home Loan, Car Loan, and Gold Loan** and demonstrates practical usage of Core Java and Object-Oriented Programming concepts.

---

## Project Overview

The application collects customer information such as **salary, age, CIBIL score, phone number, Aadhaar number, and PAN details**. Based on loan-specific eligibility rules, it determines whether the customer is eligible for the selected loan.

After basic eligibility is satisfied, the application validates customer document formats using **Regular Expressions**. It then performs **CIBIL-based risk assessment** and calculates the final **Rate of Interest (ROI)** using a loan-specific base ROI and CIBIL-based adjustment.

If all validations are successful, the loan is approved and loan-specific document verification is performed.

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
