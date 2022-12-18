package br.com.futurodev.elaboracaosecurity.controller;

import br.com.futurodev.elaboracaosecurity.model.Tutor;
import br.com.futurodev.elaboracaosecurity.service.TutorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
public class TutorControler {

    @Autowired
    private TutorService tutorService;
    @GetMapping
    public List<Tutor> getTutores(){
        return tutorService.buscarTutores();
    }
    @PostMapping
    public Tutor postTutores(@RequestBody Tutor tutor){
        return tutorService.salvar(tutor);
    }@PutMapping
    public Tutor putTutores(@RequestBody Tutor tutor){
        return tutorService.salvar(tutor);
    }@DeleteMapping
    public boolean deleteTutores(@RequestBody Integer id){
        tutorService.excluir(id);
        return true;
    }
}

