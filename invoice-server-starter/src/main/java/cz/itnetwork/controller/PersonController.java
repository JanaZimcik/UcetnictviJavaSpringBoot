/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 *   PROGRAMOVÁNÍ  <>  DESIGN  <>  PRÁCE/PODNIKÁNÍ  <>  HW A SW
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 */
package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class handles HTTP requests related to persons. It exposes endpoints for managing persons, including adding, retrieving, updating, and deleting person information.
 */
@RestController
@RequestMapping("/api")
public class PersonController {

    /**
     * The instance for handling person-related business logic.
     */
    @Autowired
    private PersonService personService;

    /**
     * Adds a new persons
     * @param personDTO containing the details of the person to be added
     * @return representing the added person
     */
    @PostMapping({"/persons", "/persons/"})
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return  personService.addPerson(personDTO);
    }

    /**
     * Returns all persons in the database
     * @return List of all persons
     */
    @GetMapping({"/persons", "/persons/"})
    public List<PersonDTO> getPersons() {
        return personService.getAll();
    }

    /**
     * Deletes an existing person
     * @param personId the unique identifier of the person to be deleted
     */
    @DeleteMapping({"/persons/{personId}", "/persons/{personId}/"})
    public void deletePerson(@PathVariable Long personId) {
        personService.removePerson(personId);
    }

    /**
     * Returns details of the existing person
     * @param personId The unique identifier of the person to be retrieved
     * @return returns the details of choosen person
     */
    @GetMapping({"/persons/{personId}", "/persons/{personId}/"})
    public PersonDTO getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    /**
     * Update the information of existing person, create new person with new id, old person will be hidden
     * @param personId The unique identifier of the person to be edited
     * @param personDTO containing the updated details of the person
     * @return returns new person with updated information
     */
    @PutMapping({"persons/{personId}", "persons/{personId}/"})
    public PersonDTO editPerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) {
        return personService.editPerson(personId, personDTO);
    }

    /**
     * Retrieves all invoices related to a seller identified by their identification number.
     * @param identificationNumber The identification number of the seller.
     * @return A list of the seller's invoices
     */
    @GetMapping({"/identification/{identificationNumber}/sales", "/identification/{identificationNumber}/sales/"})
    public List<InvoiceDTO> getAllSellersInvoices(@PathVariable String identificationNumber) {
        return personService.getAllSellersInvoices(identificationNumber);
    }

    /**
     * Retrieves all invoices related to a buyer identified by their identification number.
     *
     * @param identificationNumber The identification number of the buyer.
     * @return A list of the buyer's invoices
     */
    @GetMapping({"/identification/{identificationNumber}/purchases", "/identification/{identificationNumber}/purchases/"})
    public List<InvoiceDTO> getAllBuyersInvoices(@PathVariable String identificationNumber) {
        return personService.getAllBuyersInvoices(identificationNumber);
    }

}

