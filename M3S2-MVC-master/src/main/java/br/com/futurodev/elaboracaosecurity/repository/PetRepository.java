package br.com.futurodev.elaboracaosecurity.repository;

import br.com.futurodev.elaboracaosecurity.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {
    private static int indice = 1;
    private static List<Pet> pets = new ArrayList<>();

    private int gerarID(){
        return indice++;
    }

    public Pet save(Pet pet){
        if (pet.getId() == null) { 
            pet.setId(gerarID());

        } else { 
            Pet petsOld = findByID(pet.getId());
            delete(pet.getId());

        }
        pets.add(pet);
        return pet;
    }
    public Pet findByID(Integer id){
        if (id == null)
            return null;
        for (Pet pet : pets) {
            if (id.equals(pet.getId())) {
                return pet;
            }
        }
        return null;
    }

    public List<Pet> findAll(){
        return pets;
    }
    public void delete(Integer id){
        Pet petOld = findByID(id);
        pets.remove(petOld);
    }
}
