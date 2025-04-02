package domain.validador;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    public void puedeInscribirseAAyEDPorqueNoPideCorrelativas(){
        // Creo materias
        Materia ayed = new Materia("AyED");

        // Creo alumno sin materias aprobadas
        Alumno alumno = new Alumno();

        // Intentar inscribirse en "AyED"
        Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(ayed));

        // Verificar que la inscripción es válida
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void puedeInscribirseADdSIPorqueCumpleCorrelativas(){
        // Creo materias
        Materia ayed = new Materia("AyED");
        Materia pdp = new Materia("PDP");
        Materia ddsi = new Materia("DdSI");

        // Configuro correlativas
        pdp.agregarCorrelativa(ayed);
        ddsi.agregarCorrelativa(pdp);

        // Creo alumno con ambas aprobadas
        Alumno alumno = new Alumno();
        alumno.aprobarMaterias(ayed, pdp);

        // Intentar inscribirse en "DdSI"
        Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(ddsi));

        // Verificar que la inscripción es válida
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void noPuedeInscribirseADdSIPorqueLeFaltanCorrelativas(){
        // Creo materias
        Materia ayed = new Materia("AyED");
        Materia pdp = new Materia("PDP");
        Materia ddsi = new Materia("DdSI");

        // Configuro correlativas
        pdp.agregarCorrelativa(ayed);
        ddsi.agregarCorrelativa(pdp);

        // Creo alumno y aprueba solo "AyED" (le falta "PDP")
        Alumno alumno = new Alumno();
        alumno.aprobarMaterias(ayed);

        // Intentar inscribirse en "DdSI"
        Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(ddsi));

        // Verificar que la inscripción es rechazada
        assertFalse(inscripcion.aprobada());
    }

    @Test
    public void puedeInscribirseAAMIyDdSIPorqueCumpleCorrelativas(){
        // Creo materias
        Materia ayed = new Materia("AyED");
        Materia pdp = new Materia("PDP");
        Materia ddsi = new Materia("DdSI");
        Materia am1 = new Materia("AMI");

        // Configuro correlativas
        pdp.agregarCorrelativa(ayed);
        ddsi.agregarCorrelativa(pdp);

        // Creo alumno con ambas aprobadas
        Alumno alumno = new Alumno();
        alumno.aprobarMaterias(ayed, pdp);

        // Intentar inscribirse en "DdSI" y en "AM1"
        Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(am1, ddsi));

        // Verificar que la inscripción es válida
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void noPuedeInscribirsePorqueLeFaltanCorrelativasEnAMII(){
        // Creo materias
        Materia ayed = new Materia("AyED");
        Materia pdp = new Materia("PDP");
        Materia ddsi = new Materia("DdSI");
        Materia am1 = new Materia("AMI");
        Materia am2 = new Materia("AMII");

        // Configuro correlativas
        pdp.agregarCorrelativa(ayed);
        ddsi.agregarCorrelativa(pdp);
        am2.agregarCorrelativa(am1);

        // Creo alumno y aprueba "AyED","PDP" (no aprueba "AM1")
        Alumno alumno = new Alumno();
        alumno.aprobarMaterias(pdp, ayed);

        // Intentar inscribirse en "DdSI" y "AM2"
        Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(ddsi,am2));

        // Verificar que la inscripción es rechazada
        assertFalse(inscripcion.aprobada());
    }

}