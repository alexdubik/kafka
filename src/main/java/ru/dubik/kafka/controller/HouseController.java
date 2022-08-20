package ru.dubik.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.dubik.kafka.dto.HouseDto;
import ru.dubik.kafka.queue.StreamSender;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/house")
public class HouseController {

    private final StreamSender streamSender;

    @PostMapping("/kafka")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendToKafka(@RequestBody @Valid HouseDto houseDTO) {
        streamSender.sendMessage(houseDTO);
    }

}