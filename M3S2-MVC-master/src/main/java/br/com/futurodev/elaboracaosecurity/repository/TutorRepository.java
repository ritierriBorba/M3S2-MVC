package br.com.futurodev.elaboracaosecurity.repository;

import br.com.futurodev.elaboracaosecurity.model.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    private static int indice = 1;
    private static List<Tutor> tutores = new ArrayList<>();

    private int gerarID() {
        return indice++;
    }

    public Tutor save(Tutor tutor) {
        if (tutor.getId() == null) {
            tutor.setId(gerarID());

        } else {
            Tutor tutorOld = findByID(tutor.getId());
            delete(tutor.getId());

        }
        tutores.add(tutor);
        return tutor;
    }

    public Tutor findByID(Integer id) {
        if (id == null)
            return null;
        for (Tutor tutor : tutores) {
            if (id.equals(tutor.getId())) {
                return tutor;
            }
        }
        return null;
    }

    public List<Tutor> findAll() {
        return tutores;
    }

    public void delete(Integer id) {
        Tutor tutorOld = findByID(id);
        tutores.remove(tutorOld);
    }

}
