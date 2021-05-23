package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ModeloNotFoundException;
import com.example.demo.model.Alumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno findById(Integer id_alumno) throws Exception {
		Optional<Alumno> op = alumnoRepository.findById(id_alumno);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_alumno);
		}
		return op.get();
	}

	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
		
	}

	@Override
	public Alumno save(Alumno alumno) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Alumno alu = alumnoRepository.save(alumno);
        return alu;
	
	}

	@Override
	public Alumno update(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public boolean deleteById(Integer id_alumno) throws Exception {
		Optional<Alumno> op = alumnoRepository.findById(id_alumno);
		if(!op.isPresent()){
			throw new ModeloNotFoundException("ID NO ENCONTRADO:" + id_alumno);
		}
		alumnoRepository.deleteById(id_alumno);
		return true;
	}

}
