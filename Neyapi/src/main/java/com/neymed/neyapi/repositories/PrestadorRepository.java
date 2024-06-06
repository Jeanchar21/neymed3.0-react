package com.neymed.neyapi.repositories;

import com.neymed.neyapi.models.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    boolean existsBycpfval(String cpf);
    boolean existsBycnpjval(String cnpj);
}