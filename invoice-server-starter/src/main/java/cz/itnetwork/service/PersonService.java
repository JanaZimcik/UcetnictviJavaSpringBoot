package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    /**
     * Creates a new person
     *
     * @param personDTO Person to create
     * @return newly created person
     */
    PersonDTO addPerson(PersonDTO personDTO);

    /**
     * <p>Sets hidden flag to true for the person with the matching [id]</p>
     * <p>In case a person with the passed [id] isn't found, the method <b>silently fails</b></p>
     *
     * @param id Person to delete
     */
    void removePerson(long id);

    /**
     * Fetches all non-hidden persons
     *
     * @return List of all non-hidden persons
     */
    List<PersonDTO> getAll();

    /**
     * Get a person detail info by id
     * @param personId of person
     * @return data of person
     */
    PersonDTO getPerson(long personId);

    /**
     * Update the information of person by id. Creates new person with new id, old person will be hidden
     * @param personId of edited person
     * @param personDTO data of the person to be edited
     * @return new person with updated information
     */
    PersonDTO editPerson(long personId, PersonDTO personDTO);

    /**
     * List of all invoices of the person chosen by his identification number
     * @param identificationNumber The identification number of the seller
     * @return A list of the seller's invoices
     */
    List<InvoiceDTO> getAllSellersInvoices(String identificationNumber);

    /**
     * List of all invoices of the person chosen by his identification number
     * @param identificationNumber The identification number of the buyer
     * @return A list of the buyer's invoices
     */
    List<InvoiceDTO> getAllBuyersInvoices(String identificationNumber);
}
