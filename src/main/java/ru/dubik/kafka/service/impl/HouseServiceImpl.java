package ru.dubik.kafka.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dubik.kafka.model.House;
import ru.dubik.kafka.repository.HouseRepository;
import ru.dubik.kafka.service.HouseService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository repository;

    @Override
    public House save(House entity) {
        return repository.save(entity);
    }

    @Override
    public List<House> save(List<House> entities) {
        return (List<House>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<House> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<House> findAll() {
        return (List<House>) repository.findAll();
    }

    @Override
    public Page<House> findAll(Pageable pageable) {
        Page<House> entityPage = repository.findAll(pageable);
        List<House> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }


    @Override
    public House update(House entity, UUID id) {
        Optional<House> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}