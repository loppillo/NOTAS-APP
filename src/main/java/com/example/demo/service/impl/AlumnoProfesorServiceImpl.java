package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.AlumnoProfesor;
import com.example.demo.repository.AlumnoProfesorRepository;
import com.example.demo.service.AlumnoProfesorService;

@Service
public class AlumnoProfesorServiceImpl implements AlumnoProfesorService {

	@Autowired
	private AlumnoProfesorRepository alumnoProfesorRepository;

	@Override
	public List<AlumnoProfesor> listarProfesoresPorAlumno(Integer id_alumno) {
		return alumnoProfesorRepository.listarProfesoresPorAlumno(id_alumno);
	}
	
	
	

}
