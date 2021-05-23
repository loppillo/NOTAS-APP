package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AlumnoProfesor;



public interface AlumnoProfesorService {
	
	List<AlumnoProfesor> listarProfesoresPorAlumno(Integer id_alumno);

}
