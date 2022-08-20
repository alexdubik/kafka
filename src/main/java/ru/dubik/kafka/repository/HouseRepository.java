package ru.dubik.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.dubik.kafka.model.House;

import java.util.UUID;

@Repository
public interface HouseRepository extends JpaRepository<House, UUID> {
}