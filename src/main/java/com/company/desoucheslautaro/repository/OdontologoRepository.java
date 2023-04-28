package com.company.desoucheslautaro.repository;

import com.company.desoucheslautaro.entity.Odontologo;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo o WHERE o.matricula = ?1")
    public Optional<Odontologo> buscarPorMatricula(Long matricula);

}
