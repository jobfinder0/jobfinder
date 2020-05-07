package resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import aiss.resources.LinkedInResource;

public class LinkedInTest {
	
		String accessToken = "AQUQow2rEZsnt0ABvniTS6wEsPN-SzDKjruVu9b-7nTE7gqWr4ISDM-TOs2ucwpmFNiEvOqAOnzugPvJaOW6LtkII79KbrSY32EttnxyWJ5N0SUeE-eNgGxCiVzJt8MyLuLkVoPXIjCv9PGqXpxI_ywfVhyG0yD5deTHynfzBIhUC7okbWNQK38g-zHBq0TRlZutforhHVkJXhNM2YCL3DSGRFLNhnrs9wXpH3L27GEud0mNJj86I2VrWHQ-5tqxvUKrGjo9IgxOtR754ZSGuBNDaEO9RVBw4Pcg1QlO8qFFPbd0rSt_sBJVIyi5UNPnkk7nLbQf_SsfVKB2A7Pn-Z415Xs5bg";
		String id = "ssdHPjENix";
		@Test
		public void getId() {
			// Creamos el recurso y hacemos la llamada para obtener el id
			LinkedInResource linkResource = new LinkedInResource();
			String result = linkResource.getId(accessToken);
			
			// Comprobamos que la búsqueda no devuelve null
			assertNotNull("La búsqueda devolvió null", result);
			//Comprobamos que la búsqueda devuelve el id correcto
			assertEquals("La búsqueda devolvió un id incorrecto",result, id);
	    }
		
		@Test
		public void ucgPost() {
			String shareCommentary = "Curso muy útil.";
			String title = "Aprender a programar con Java. De cero hasta hacer Sistemas";
			String url = "https://www.tutellus.com/tecnologia/software/aprender-a-programar-con-java-de-cero-hasta-hacer-sistemas-16259?affref=8bb8cbc549604cb195e44564cdd91cb2";
			String web = "https://www.tutellus.com";
			
			// Creamos el recurso y hacemos la llamada
			LinkedInResource linResource = new LinkedInResource();
			
			try {
			linResource.ugcPost(shareCommentary, title, url, web, accessToken);
			}catch(Exception e){
				//Si entra es porque no se ha realizado bien la llamada.
				new AssertionError("No se ha realizado bien la llamada");
			}
			}
}
