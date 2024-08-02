package com.example.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.InvoiceManager;
import com.example.entities.InvoiceDetail;

@RestController
@RequestMapping("/api/invoice-details")
public class InvoiceDetailController {

    @Autowired
    private InvoiceManager invoiceDetailService;

    @GetMapping
    public List<InvoiceDetail> getAllInvoiceDetails() {
        return invoiceDetailService.getAllInvoiceDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetail> getInvoiceDetailById(@PathVariable Long id) {
        Optional<InvoiceDetail> invoiceDetail = invoiceDetailService.getInvoiceDetailById(id);
        return invoiceDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InvoiceDetail> createInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
        InvoiceDetail savedInvoiceDetail = invoiceDetailService.saveInvoiceDetail(invoiceDetail);
        return ResponseEntity.ok(savedInvoiceDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDetail> updateInvoiceDetail(@PathVariable Long id, @RequestBody InvoiceDetail invoiceDetail) {
        if (!invoiceDetailService.getInvoiceDetailById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceDetail.setInvDtlId(id);
        InvoiceDetail updatedInvoiceDetail = invoiceDetailService.saveInvoiceDetail(invoiceDetail);
        return ResponseEntity.ok(updatedInvoiceDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceDetail(@PathVariable Long id) {
        if (!invoiceDetailService.getInvoiceDetailById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceDetailService.deleteInvoiceDetail(id);
        return ResponseEntity.noContent().build();
    }
}
