package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información o propiedades de Curso")

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_curso;
	
	@Size(min=3,max=20,message="El nombre del curso debe ser igual o mayor de 3 y menor o igual a 20")
	@Column(name="nombre_curso", length = 20)
	private String Nombre_curso;
	
	



	public Integer getId_curso() {
		return id_curso;
	}


	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}


	public String getNombre_curso() {
		return Nombre_curso;
	}


	public void setNombre_curso(String nombre_curso) {
		Nombre_curso = nombre_curso;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre_curso == null) ? 0 : Nombre_curso.hashCode());
		result = prime * result + ((id_curso == null) ? 0 : id_curso.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (Nombre_curso == null) {
			if (other.Nombre_curso != null)
				return false;
		} else if (!Nombre_curso.equals(other.Nombre_curso))
			return false;
		if (id_curso == null) {
			if (other.id_curso != null)
				return false;
		} else if (!id_curso.equals(other.id_curso))
			return false;
		return true;
	}
	
	
	
	
}
