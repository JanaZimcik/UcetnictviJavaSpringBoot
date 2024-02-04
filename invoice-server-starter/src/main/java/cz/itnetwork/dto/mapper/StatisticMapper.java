package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.StatisticDTO;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.StatisticEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper {

    StatisticEntity toEntity(StatisticDTO source);

    StatisticDTO toDTO(StatisticEntity source);
}
