package cz.itnetwork.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StatisticEntity.class)
public abstract class StatisticEntity_ {

	public static volatile SingularAttribute<StatisticEntity, String> personName;
	public static volatile SingularAttribute<StatisticEntity, BigDecimal> revenue;
	public static volatile SingularAttribute<StatisticEntity, BigDecimal> allTimeSum;
	public static volatile SingularAttribute<StatisticEntity, BigDecimal> currentYearSum;
	public static volatile SingularAttribute<StatisticEntity, Long> personId;
	public static volatile SingularAttribute<StatisticEntity, Long> id;
	public static volatile SingularAttribute<StatisticEntity, Long> invoicesCount;

	public static final String PERSON_NAME = "personName";
	public static final String REVENUE = "revenue";
	public static final String ALL_TIME_SUM = "allTimeSum";
	public static final String CURRENT_YEAR_SUM = "currentYearSum";
	public static final String PERSON_ID = "personId";
	public static final String ID = "id";
	public static final String INVOICES_COUNT = "invoicesCount";

}

