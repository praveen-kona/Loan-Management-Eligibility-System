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
