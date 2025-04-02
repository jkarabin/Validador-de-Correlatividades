package domain.validador;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.correlativas = new ArrayList<Materia>();
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativa(Materia correlativa) {
        this.correlativas.add(correlativa);
    }

}
