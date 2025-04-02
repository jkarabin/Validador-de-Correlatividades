package domain.validador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alumno {
    //Habia creado los atributos nombre, apellido, padron, pero los borre por el mensaje "Fields never used"

    private List<Materia> aprobadas;

    public Alumno() {
        this.aprobadas = new ArrayList<>();
    }

    public List<Materia> getAprobadas() {
        return aprobadas;
    }

    public void aprobarMaterias(Materia... materias) {
        this.aprobadas.addAll(Arrays.asList(materias));
    }

}
