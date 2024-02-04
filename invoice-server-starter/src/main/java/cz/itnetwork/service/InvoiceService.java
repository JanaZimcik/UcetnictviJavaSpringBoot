package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;

import java.util.List;

/**
 * The interface defines methods for managing invoices and retrieving related information. It serves as a contract for implementing classes that provide business logic for invoice operations.
 */
public interface InvoiceService {

    /**
     * Adds a new invoice.
     * @param invoiceDTO containing the details of the invoice to be added.
     * @return representing the added invoice.
     */
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    /**
     * Edits an existing invoice.
     * @param invoiceId The unique identifier of the invoice to be edited.
     * @param invoiceDTO containing the updated details of the invoice.
     * @return representing the edited invoice.
     */
    InvoiceDTO editInvoice(long invoiceId, InvoiceDTO invoiceDTO);

    /**
     * Removes an existing invoice.
     * @param invoiceId The unique identifier of the invoice to be removed.
     */
    void removeInvoice(long invoiceId);

    /**
     * Retrieves details of a specific invoice.
     * @param invoiceId The unique identifier of the invoice to be retrieved.
     * @return representing the requested invoice
     */
    InvoiceDTO getInvoice(long invoiceId);

    /**
     * Retrieves a list of invoices based on the provided filter criteria.
     * @param invoiceFilter containing filter criteria for retrieving invoices
     * @return representing the filtered invoices
     */
    List<InvoiceDTO> getAllInvoices(InvoiceFilter invoiceFilter);

    /**
     * Retrieves a list of all products associated with invoices.
     * @return a list representing the names of all products.
     */
    List<String> getAllProducts();
}
