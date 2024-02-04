package cz.itnetwork.service;

import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.dto.StatisticDTO;

import java.util.List;

/**
 * The interface defines methods for retrieving statistical information. It serves as a contract for implementing classes that provide business logic for statistical calculations.
 */
public interface StatisticService {

    /**
     * The statistic for current year sum, all time sum end invoices count
     * @return general statistics
     */
    StatisticDTO getStatistics();

    /**
     * The personal statistic which returns person id, person name and his revenue
     * @return List of all persons and their statistics
     */
    List<PersonsStatisticDTO> getPersonsStatistics();
}
