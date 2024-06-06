package com.neymed.neyapi.repositories;

import com.neymed.neyapi.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    boolean existsBycnpjval(String cnpj);
}
