package com.programacion.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion.db.Autor;
import com.programacion.db.Libro;

@ApplicationScoped
public class LibroServicioImpl implements LibroServicio{

	@Override
	public List<Libro> todoslibros() throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:9095/libros");
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse response = client.execute(get);
		String texto = EntityUtils.toString(response.getEntity());

		System.out.println("Texto es");
		System.out.println(texto);
		// transformando json--texto a una lista
		ObjectMapper mapper = new ObjectMapper();
		Libro[] lib = mapper.readValue(texto, Libro[].class);
		ArrayList<Libro> List = new ArrayList<Libro>(Arrays.asList(lib));
		client.close();
		return List;
	}

	@Override
	public ArrayList<Libro> listarLibrosAutor(int id) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:9095/libros/" + id);
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse response = client.execute(get);
		String texto = EntityUtils.toString(response.getEntity());

		System.out.println("Texto es");
		System.out.println(texto);
		// transformando json--texto a una lista
		ObjectMapper mapper = new ObjectMapper();
		Libro[] lib = mapper.readValue(texto, Libro[].class);
		ArrayList<Libro> List = new ArrayList<Libro>(Arrays.asList(lib));
		client.close();
		return List;
	}

	@Override
	public Libro buscaLibro(int id) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:9095/libros/" + id);
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse response = client.execute(get);
		String texto = EntityUtils.toString(response.getEntity());

		System.out.println("Texto es");
		System.out.println(texto);
		ObjectMapper mapper = new ObjectMapper();
		Libro aut = mapper.readValue(texto, Libro.class);
		
		client.close();return aut;
	}

	@Override
	public void CreateLibro(Libro aut) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:9095/libros");
		ObjectMapper mapper = new ObjectMapper();
		// convierto a texto
		String json = mapper.writeValueAsString(aut);
		// convierto a json
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = client.execute(httpPost);
		client.close();
		int statusCode = response.getStatusLine().getStatusCode();
	//	if (statusCode != 204) {
		//	throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	//	}
		
	}

	@Override
	public void deleteLibro(int id) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete("http://localhost:9095/libros/" + id);
		httpDelete.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpDelete);
		
		int statusCode = response.getStatusLine().getStatusCode();
		httpclient.close();
		//	if (statusCode != 204) {
			//throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		//}
		
	}

	@Override
	public void actualizarBook(Libro libro) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut("http://localhost:9095/libros");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(libro);
		StringEntity entity = new StringEntity(json);
		httpPut.setEntity(entity);
		httpPut.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpPut);
		
		int statusCode = response.getStatusLine().getStatusCode();
		httpclient.close();
		//if (statusCode != 204) {
			//throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	//	}
		
	}

}
