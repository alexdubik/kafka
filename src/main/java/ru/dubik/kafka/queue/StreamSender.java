package ru.dubik.kafka.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.dubik.kafka.dto.HouseDto;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StreamSender {

    private final StreamBridge bridge;

    public void sendMessage(HouseDto dto) {
        bridge.send("createHouse-out-0", buildMessage(dto));
    }

    private Message<?> buildMessage(Object o) {
        return MessageBuilder.createMessage(o, new MessageHeaders(Map.of(MessageHeaders.CONTENT_TYPE, "application/json")));
    }

}
