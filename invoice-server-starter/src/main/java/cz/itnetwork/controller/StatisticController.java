package cz.itnetwork.controller;

import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.dto.StatisticDTO;
import cz.itnetwork.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The class handles HTTP requests related to statistics. It exposes endpoints for retrieving general statistics and person-specific statistics.
 */
@RestController
@RequestMapping("/api")
public class StatisticController {
    /**
     * The instance for handling statistical calculations
     */
    @Autowired
    StatisticService statisticService;

    /**
     * The statistic for current year sum, all time sum end invoices count
     * @return general statistics
     */
    @GetMapping({"/invoices/statistics", "/invoices/statistics/"})
    public StatisticDTO getStatistics() {
        return statisticService.getStatistics();
    }

    /**
     * The personal statistic which returns person id, person name and his revenue
     * @return List of all persons and their statistics
     */
    @GetMapping({"/persons/statistics", "/persons/statistics/"})
    public List<PersonsStatisticDTO> getPersonsStatistics() {
        return statisticService.getPersonsStatistics();
    }
}
