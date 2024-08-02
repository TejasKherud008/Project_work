package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invDtlId;

    private Long invoiceId;
    private Long addOnId;
    private Double addOnAmt;

    // Getters and Setters

    public Long getInvDtlId() {
        return invDtlId;
    }

    public void setInvDtlId(Long invDtlId) {
        this.invDtlId = invDtlId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(Long addOnId) {
        this.addOnId = addOnId;
    }

    public Double getAddOnAmt() {
        return addOnAmt;
    }

    public void setAddOnAmt(Double addOnAmt) {
        this.addOnAmt = addOnAmt;
    }
}

