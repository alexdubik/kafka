package ru.dubik.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dubik.kafka.model.enums.HouseType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {

    private UUID id;

    @NotBlank
    private String name;

    @NotNull
    private HouseType type;

    @Min(0)
    @NotNull
    private Integer floor;

}
