package ru.liga.uploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.uploader.entity.TemplateEntity;

public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {

}
