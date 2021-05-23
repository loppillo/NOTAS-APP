package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.AlumnoProfesor;



public interface AlumnoProfesorRepository extends JpaRepository<AlumnoProfesor, Integer>{

	
	@Query("from AlumnoProfesor ap where ap.alumno.id_alumno = :id_alumno")
	List<AlumnoProfesor> listarProfesoresPorAlumno(@Param("id_alumno") Integer id_alumno);
	
}
