package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AlumnoAsignatura;


public interface AlumnoAsignaturaService {

	List<AlumnoAsignatura> listarAsignaturasPorAlumno(Integer id_alumno);
}
