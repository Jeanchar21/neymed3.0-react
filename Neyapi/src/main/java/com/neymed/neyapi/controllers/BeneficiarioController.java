package com.neymed.neyapi.controllers;

import com.neymed.neyapi.DTO.BeneficiarioResponseDTO;
import com.neymed.neyapi.models.Beneficiario;
import com.neymed.neyapi.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService service;
    @GetMapping
    public ResponseEntity<List<Beneficiario>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<BeneficiarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<Beneficiario> insert(@RequestBody BeneficiarioResponseDTO beneficiarioResponseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(beneficiarioResponseDTO));
    }
    @PutMapping("/{id}")
    public Beneficiario update(@PathVariable Long id,@RequestBody Beneficiario beneficiario){

        return  service.update(id, beneficiario);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
