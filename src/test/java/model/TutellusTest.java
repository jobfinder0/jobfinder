package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import aiss.model.common.CourseCommon;
import aiss.model.tutellus.TutellusCourse;
import aiss.resources.TutellusResource;

public class TutellusTest {
	
		@Test
		public void getCourses() {
			// Creamos la variable 
			String search = "Java";
			
			// Creamos el recurso y hacemos la llamada para obtener los cursos
			TutellusResource tutResource = new TutellusResource();
			List<CourseCommon> results = tutResource.getCourses(search);
			
			// Comprobamos que la búsqueda no devuelve null
			assertNotNull("La búsqueda devolvió null", results);
	    }
		
		@Test
		public void getCourse() {
			
			// Creamos la variable 
			String code = "16259";
			
			// Creamos el recurso y hacemos la llamada para obtener el cursos
			TutellusResource tutResource = new TutellusResource();
			TutellusCourse result = tutResource.getCourse(code);
			
			// Comprobamos que la búsqueda no devuelve null
			assertNotNull("La búsqueda devolvió null", result);
			assertTrue("No coincide con el curso", result.getName().contains("Aprender a programar con Java"));
	    }
}
