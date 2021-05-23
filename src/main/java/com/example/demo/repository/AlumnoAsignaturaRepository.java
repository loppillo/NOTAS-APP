package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.AlumnoAsignatura;


public interface AlumnoAsignaturaRepository extends JpaRepository<AlumnoAsignatura, Integer> {

	@Query("from AlumnoAsignatura ap where ap.alumno.id_alumno = :id_alumno")
	List<AlumnoAsignatura> listarAsignaturasPorAlumno(@Param("id_alumno") Integer id_alumno);
	

}
