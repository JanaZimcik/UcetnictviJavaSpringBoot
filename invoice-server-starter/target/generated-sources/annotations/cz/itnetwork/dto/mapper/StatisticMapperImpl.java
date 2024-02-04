package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.StatisticDTO;
import cz.itnetwork.entity.StatisticEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Eclipse Adoptium)"
)
@Component
public class StatisticMapperImpl implements StatisticMapper {

    @Override
    public StatisticEntity toEntity(StatisticDTO source) {
        if ( source == null ) {
            return null;
        }

        StatisticEntity statisticEntity = new StatisticEntity();

        statisticEntity.setCurrentYearSum( source.getCurrentYearSum() );
        statisticEntity.setAllTimeSum( source.getAllTimeSum() );
        statisticEntity.setInvoicesCount( source.getInvoicesCount() );

        return statisticEntity;
    }

    @Override
    public StatisticDTO toDTO(StatisticEntity source) {
        if ( source == null ) {
            return null;
        }

        StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setCurrentYearSum( source.getCurrentYearSum() );
        statisticDTO.setAllTimeSum( source.getAllTimeSum() );
        statisticDTO.setInvoicesCount( source.getInvoicesCount() );

        return statisticDTO;
    }
}
