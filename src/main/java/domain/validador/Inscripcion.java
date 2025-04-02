package domain.validador;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> asignaturas;

    public Inscripcion(Alumno alumno, List<Materia> asignaturas) {
        this.alumno = alumno;
        this.asignaturas = asignaturas;
    }

    public boolean aprobada(){
        for (Materia materia : asignaturas) {
            for (Materia correlativa : materia.getCorrelativas()) {
                if (!alumno.getAprobadas().contains(correlativa)) {
                    return false;
                }
            }
        }
        return true;
    }

}