package ru.dubik.kafka.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import ru.dubik.kafka.dto.HouseDto;
import ru.dubik.kafka.mapper.HouseMapper;
import ru.dubik.kafka.service.HouseService;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class StreamListener {

    private final HouseService houseService;
    private final HouseMapper mapper;

    @Bean
    public Consumer<Message<HouseDto>> createHouse() {
        return payload -> {
            log.info("Received house payload {}", payload);
            houseService.save(mapper.asEntity(payload.getPayload()));
        };
    }

}
