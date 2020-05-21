package ru.liga.uploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.uploader.entity.OrganizationMappingEntity;

@Repository
public interface OrganizationMappingRepository extends JpaRepository<OrganizationMappingEntity, Long> {

    OrganizationMappingEntity findByOldOrganizationId(Long oldOrganizationId);
}
