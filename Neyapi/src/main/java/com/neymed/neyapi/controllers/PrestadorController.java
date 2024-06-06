package com.neymed.neyapi.controllers;

import com.neymed.neyapi.DTO.PrestadorResponseDTO;
import com.neymed.neyapi.models.Prestador;
import com.neymed.neyapi.services.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorService service;
    @GetMapping
    public List<Prestador> findAll(){
        return service.findAll();
    }
    @GetMapping(value = "/{id}")
    public PrestadorResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping
    public PrestadorResponseDTO insert(@RequestBody PrestadorResponseDTO prestadorResponseDTO) {
        return service.save(prestadorResponseDTO);
    }

    @PutMapping("/{id}")
    public Prestador update(@PathVariable Long id,@RequestBody Prestador prestador){

        return  service.update(id, prestador);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
