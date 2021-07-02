package ru.liga.uploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.uploader.entity.FRGUService;

@Repository
public interface FRGUServiceDao extends JpaRepository<FRGUService, Long> {
}
