package com.neymed.neyapi.repositories;

import com.neymed.neyapi.models.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    boolean existsBycpfval(String cpf);
}
