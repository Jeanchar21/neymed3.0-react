package com.neymed.neyapi.controllers;

import com.neymed.neyapi.DTO.EmpresaResponseDTO;
import com.neymed.neyapi.models.Empresa;
import com.neymed.neyapi.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService service;
    @GetMapping
    public List<Empresa> findAll(){
        return service.findAll();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> insert(@RequestBody EmpresaResponseDTO empresaResponseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresaResponseDTO));
    }

    @PutMapping("/{id}")
    public Empresa update(@PathVariable Long id,@RequestBody Empresa empresa){

        return  service.update(id, empresa);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
