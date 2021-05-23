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
import com.example.demo.model.AlumnoAsignatura;
import com.example.demo.service.AlumnoAsignaturaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/alumnoasignaturas")
public class AlumnoAsignaturaController {

	@Autowired
	private AlumnoAsignaturaService service;
	
	@ApiOperation(value = "Obtener lista de asignatura por alumno",
			notes = "Se necesita la id del alumno",
			response = List.class,
			responseContainer = "AlumnoAsignatura")
			@ApiResponses(value = {
				@ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
				@ApiResponse(code = 404, message = "Not found, no encontrado"),
				@ApiResponse(code = 405, message = "No se encontró la asignatura por alumno en la BD"),
				@ApiResponse(code = 200, message = "Petición OK")})
		
	
	@GetMapping(value = "/{id_alumno}")
	public ResponseEntity<List<AlumnoAsignatura>> listar(@PathVariable("id_alumno") Integer id_alumno) {
		List<AlumnoAsignatura> alumnoasignatura= new ArrayList<>();
		alumnoasignatura= service.listarAsignaturasPorAlumno(id_alumno);
		return new ResponseEntity<List<AlumnoAsignatura>>(alumnoasignatura, HttpStatus.OK);
	}
	
}
