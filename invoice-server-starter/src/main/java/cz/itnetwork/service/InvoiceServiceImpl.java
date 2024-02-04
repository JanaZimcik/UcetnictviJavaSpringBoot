package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import cz.itnetwork.entity.repository.specification.InvoiceSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity entity = invoiceMapper.toEntity(invoiceDTO);
        entity = invoiceRepository.save(entity);
        entity.setBuyer(personRepository.getReferenceById(invoiceDTO.getBuyer().getId()));
        entity.setSeller(personRepository.getReferenceById(invoiceDTO.getSeller().getId()));

        return invoiceMapper.toDTO(entity);
    }

    public InvoiceDTO editInvoice(long invoiceId, InvoiceDTO invoiceDTO) {
        // TODO: fetchInvoiceBy
        if(!invoiceRepository.existsById(invoiceId)) {
            throw new EntityNotFoundException("Invoice with id " + invoiceId + " wasn't found in the database.");
        }

        InvoiceEntity entity = invoiceMapper.toEntity(invoiceDTO);
        entity.setId(invoiceId);
        InvoiceEntity saved = invoiceRepository.save(entity);
        return invoiceMapper.toDTO(saved);
    }

    public void removeInvoice(long invoiceId) {
        try {
            InvoiceEntity invoice = fetchInvoiceById(invoiceId);
            invoiceRepository.delete(invoice);
        } catch (NotFoundException ignored){
        }
    }

    private InvoiceEntity fetchInvoiceById(long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice with id " + id + " wasn't found in the database."));
    }

    public InvoiceDTO getInvoice(long invoiceId) {
        return  invoiceMapper.toDTO(fetchInvoiceById(invoiceId));
    }

    public List<InvoiceDTO> getAllInvoices(InvoiceFilter invoiceFilter) {
        InvoiceSpecification invoiceSpecification = new InvoiceSpecification(invoiceFilter);

        return invoiceRepository.findAll(invoiceSpecification, PageRequest.of(0, invoiceFilter.getLimit()))
                .stream()
                .map(invoiceMapper::toDTO)
                .toList();
    }

    public List<String> getAllProducts() {
        List<InvoiceEntity> invoices = invoiceRepository.findAll();
        List<String> products = new ArrayList<>();
        for (InvoiceEntity invoice : invoices) {
            if(!products.contains(invoice.getProduct())) {
                products.add(invoice.getProduct());
            }
        }
        return products;
    }
}
