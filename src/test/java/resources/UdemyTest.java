package resources;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.google.appengine.repackaged.com.google.gson.JsonSyntaxException;

import aiss.model.common.CourseCommon;
import aiss.model.udemy.Result;
import aiss.resources.UdemyResource;

public class UdemyTest {
	
		@Test
		public void getCourses() throws JsonSyntaxException, ClientProtocolException, IOException {
			// Creamos la variable 
			String search = "Java";
			
			// Creamos el recurso y hacemos la llamada para obtener los cursos
			UdemyResource udeResource = new UdemyResource();
			List<CourseCommon> results = udeResource.getCourses(search);
			
			// Comprobamos que la búsqueda no devuelve null
			assertNotNull("La búsqueda devolvió null", results);
	    }
		
		@Test
		public void getCourse() throws JsonSyntaxException, ClientProtocolException, IOException {
			
			// Creamos la variable 
			String code = "533682";
			
			// Creamos el recurso y hacemos la llamada para obtener el cursos
			UdemyResource udeResource = new UdemyResource();
			Result result = udeResource.getCourse(code);
			
			// Comprobamos que la búsqueda no devuelve null
			assertNotNull("La búsqueda devolvió null", result);
			assertTrue("No coincide con el curso", result.getTitle().contains("Java Programming Masterclass for Software Developers"));
	    }
}
