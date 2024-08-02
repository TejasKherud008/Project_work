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

import com.example.Services.InvoiceHeaderManager;
import com.example.entities.InvoiceHeader;

@RestController
@RequestMapping("api/invoice-headers")
public class InvoiceHeaderController {

    @Autowired
    private InvoiceHeaderManager invoiceHeaderService;

    @GetMapping
    public List<InvoiceHeader> getAllInvoiceHeaders() {
        return invoiceHeaderService.getAllInvoiceHeaders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceHeader> getInvoiceHeaderById(@PathVariable Long id) {
        Optional<InvoiceHeader> invoiceHeader = invoiceHeaderService.getInvoiceHeaderById(id);
        return invoiceHeader.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("createInvoiceHeader")
    public ResponseEntity<InvoiceHeader> createInvoiceHeader(@RequestBody InvoiceHeader invoiceHeader) {
        InvoiceHeader savedInvoiceHeader = invoiceHeaderService.saveInvoiceHeader(invoiceHeader);
        return ResponseEntity.ok(savedInvoiceHeader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceHeader> updateInvoiceHeader(@PathVariable Long id, @RequestBody InvoiceHeader invoiceHeader) {
        if (!invoiceHeaderService.getInvoiceHeaderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceHeader.setInvoiceId(id);
        InvoiceHeader updatedInvoiceHeader = invoiceHeaderService.saveInvoiceHeader(invoiceHeader);
        return ResponseEntity.ok(updatedInvoiceHeader);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceHeader(@PathVariable Long id) {
        if (!invoiceHeaderService.getInvoiceHeaderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceHeaderService.deleteInvoiceHeader(id);
        return ResponseEntity.noContent().build();
    }
}
