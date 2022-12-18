package br.com.futurodev.elaboracaosecurity.controller;

import br.com.futurodev.elaboracaosecurity.model.Pet;
import br.com.futurodev.elaboracaosecurity.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getPets(){
        return petService.buscarPets();
    }
    @PostMapping
    public Pet postPets(@RequestBody Pet pet){
        return petService.salvar(pet);
    }@PutMapping
    public Pet putPets(@RequestBody Pet pet){
        return petService.salvar(pet);
    }@DeleteMapping
    public boolean deletePets(@RequestBody Pet pet){
        petService.excluir(pet.getId());
        return true;
    }
}

