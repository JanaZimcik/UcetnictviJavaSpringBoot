package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.dto.StatisticDTO;
import cz.itnetwork.dto.mapper.StatisticMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.StatisticEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    StatisticMapper statisticMapper;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    public StatisticDTO getStatistics() {
        List<InvoiceEntity> invoices = invoiceRepository.findAll();
        BigDecimal currentYearSum = BigDecimal.ZERO;
        BigDecimal allTimeSum = BigDecimal.ZERO;
        StatisticEntity statistic = new StatisticEntity();
        int currentYear = LocalDate.now().getYear();

        for (InvoiceEntity invoice : invoices) {
            allTimeSum = allTimeSum.add(invoice.getPrice());
            if (invoice.getIssued().getYear() == currentYear) {
                currentYearSum = currentYearSum.add(invoice.getPrice());
            }
        }

        statistic.setCurrentYearSum(currentYearSum);
        statistic.setAllTimeSum(allTimeSum);
        statistic.setInvoicesCount(invoiceRepository.count());

        return statisticMapper.toDTO(statistic);
    }

    public List<PersonsStatisticDTO> getPersonsStatistics() {
        List<PersonEntity> persons = personRepository.findAll();
        List<PersonsStatisticDTO> personsStatistics = new ArrayList<>();

        for (PersonEntity person : persons) {
            if(!person.isHidden()){
            PersonsStatisticDTO personsStatisticDTO = new PersonsStatisticDTO();
            personsStatisticDTO.setPersonId(person.getId());
            personsStatisticDTO.setPersonName(person.getName());

            List<InvoiceDTO> sellersInvoices = personService.getAllSellersInvoices(person.getIdentificationNumber());

            BigDecimal revenue = sellersInvoices.stream()
                    .map(InvoiceDTO::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            personsStatisticDTO.setRevenue(revenue);
            personsStatistics.add(personsStatisticDTO);}
        }

        return personsStatistics;
    }
}
