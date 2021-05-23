package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AlumnoProfesor;
import com.example.demo.service.AlumnoProfesorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/alumnoprofesores")
public class AlumnoProfesorController {

	@Autowired
	private AlumnoProfesorService service;
	
	@ApiOperation(value = "Obtener lista de profesor por alumno",
			notes = "Se necesita la id del alumno",
			response = List.class,
			responseContainer = "Alumnos")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontró el profesor por alumnos en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
		
	@GetMapping(value = "/{id_alumno}")
	public ResponseEntity<List<AlumnoProfesor>> listar(@PathVariable("id_alumno") Integer id_alumno) {
		List<AlumnoProfesor> alumnoprofesor= new ArrayList<>();
		alumnoprofesor = service.listarProfesoresPorAlumno(id_alumno);
		return new ResponseEntity<List<AlumnoProfesor>>(alumnoprofesor, HttpStatus.OK);
	}
	
}
