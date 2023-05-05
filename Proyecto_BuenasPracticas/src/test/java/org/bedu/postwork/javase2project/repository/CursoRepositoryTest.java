package org.bedu.postwork.javase2project.repository;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.repository.CursoRepository;
import org.bedu.postwork.javase2project.repository.EstudianteRepository;
import org.bedu.postwork.javase2project.repository.MateriaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoRepositoryTest {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    @BeforeAll
    void cleanDatabase(){
        cursoRepository.deleteAll();
        estudianteRepository.deleteAll();
        materiaRepository.deleteAll();
    }

    @Test
    @DisplayName("Postwork 01: Curso Guardado")
    void puedeSalvar(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre_completo("Alfredo Cuevas");
        estudianteRepository.save(estudiante);

        Materia materia = new Materia();
        materia.setNombre("Curso Java");
        materiaRepository.save(materia);

        Curso cur = new Curso();
        cur.setCiclo("2023");
        cur.setMateria(materia);
        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante, Curso.NO_CALIFICADO);
        cur.setCalificaciones(calificaciones);
        cursoRepository.save(cur);

        assertNotNull(cur.getId());
        assertNotNull(estudiante.getId());
    }

}