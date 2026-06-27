package com.academiacrossfitapi.repository;

import com.academiacrossfitapi.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
}
