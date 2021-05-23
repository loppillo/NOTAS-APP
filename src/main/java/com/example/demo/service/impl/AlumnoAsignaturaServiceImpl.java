package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AlumnoAsignatura;
import com.example.demo.repository.AlumnoAsignaturaRepository;
import com.example.demo.service.AlumnoAsignaturaService;


@Service
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService{

	@Autowired
	private AlumnoAsignaturaRepository alumnoAsignaturaRepository;
	
	@Override
	public List<AlumnoAsignatura> listarAsignaturasPorAlumno(Integer id_alumno) {
		return alumnoAsignaturaRepository.listarAsignaturasPorAlumno(id_alumno);
	}

}
