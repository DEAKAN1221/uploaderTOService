package ru.liga.uploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.uploader.entity.WeaponEntity;

public interface WeponRepository extends JpaRepository<WeaponEntity, String> {


}
