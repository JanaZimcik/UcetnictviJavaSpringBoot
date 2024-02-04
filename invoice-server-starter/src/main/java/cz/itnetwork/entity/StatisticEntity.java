package cz.itnetwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "statistics")
@Getter
@Setter
public class StatisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal currentYearSum;

    private BigDecimal allTimeSum;

    private Long invoicesCount;

    private Long personId;

    private String personName;

    private BigDecimal revenue;
}
