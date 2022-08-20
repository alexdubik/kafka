package ru.dubik.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dubik.kafka.dto.HouseDto;
import ru.dubik.kafka.model.House;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    @Mapping(target = "id", ignore = true)
    House asEntity(HouseDto dto);

    HouseDto asDto(House house);

}