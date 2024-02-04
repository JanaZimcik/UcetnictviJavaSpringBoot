package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class handles HTTP requests related to invoices and products.
 * It exposes endpoints for performing CRUD operations on invoices and retrieving product information.
 */

@RestController
@RequestMapping("/api")
public class InvoiceController {

    /**
     * The instance for handling invoice-related business logic.
     */
    @Autowired
    InvoiceService invoiceService;

    /**
     * Adds a new invoice.
     * @param invoiceDTO containing the details of the invoice to be added
     * @return returning added invoice
     */
    @PostMapping({"/invoices", "/invoices/"})
    InvoiceDTO addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }

    /**
     * Edits an existing invoice
     * @param invoiceId The unique identifier of the invoice to be edited
     * @param invoiceDTO containing the updated detail of the invoice
     * @return returning edited invoice
     */
    @PutMapping({"/invoices/{invoiceId}", "/invoices/{invoiceId}/"})
    public InvoiceDTO editInvoice(@PathVariable Long invoiceId, @Valid @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.editInvoice(invoiceId, invoiceDTO);
    }

    /**
     * Delete an existing invoice
     * @param invoiceId The unique identifier of the invoice to be deleted
     */
    @DeleteMapping({"/invoices/{invoiceId}", "/invoices/{invoiceId}/"})
    public void deleteInvoice(@PathVariable Long invoiceId) {
        invoiceService.removeInvoice(invoiceId);
    }

    /**
     * Representing details of the invoice which was chosen by id
     * @param invoiceId The unique identifier of the invoice
     * @return returns details of the invoice
     */
    @GetMapping({"/invoices/{invoiceId}", "/invoices/{invoiceId}/"})
    public InvoiceDTO getInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }

    /**
     * Return all invoices based on the filter criteria
     * @param invoiceFilter containing filter criteria
     * @return returns all invoices that match the filter
     */
    @GetMapping({"/invoices", "/invoices/"})
    public List<InvoiceDTO> getInvoices(InvoiceFilter invoiceFilter) {
            return invoiceService.getAllInvoices(invoiceFilter);
    }

    /**
     * Selects all products to be included in the filter criteria
     * @return returns list of unique products
     */
    @GetMapping({"/products", "products"})
    public List<String> getProducts() {
        return invoiceService.getAllProducts();
    }
}
