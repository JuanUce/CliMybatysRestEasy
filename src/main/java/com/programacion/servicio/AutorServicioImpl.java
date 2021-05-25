package com.programacion.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion.db.Autor;
import com.ecwid.consul.v1.Response;

@ApplicationScoped
public class AutorServicioImpl implements AutorServicio {


	@Override
	public List<Autor> listAutores() throws IOException{		
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet("http://localhost:9090/autores" );
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse response = client.execute(get);
		String texto = EntityUtils.toString(response.getEntity());
		System.out.println("Texto es");
		System.out.println(texto);
		//transformando json--texto a una lista
		ObjectMapper mapper = new ObjectMapper();
		Autor[] aut = mapper.readValue(texto, Autor[].class);
		List<Autor> list = new ArrayList<Autor>(Arrays.asList(aut));
	        
		client.close();
		return list;
	}

	@Override
	public Autor buscarBAutores(Long id) throws Exception  {
		
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet("http://localhost:9090/autores/" + id);
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse response = client.execute(get);
		String texto = EntityUtils.toString(response.getEntity());

		System.out.println("Texto es");
		System.out.println(texto);
		ObjectMapper mapper = new ObjectMapper();
		Autor aut = mapper.readValue(texto, Autor.class);
			
		client.close();
		
		return aut;
	}

	@Override
	public void insertar(Autor aut) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:9090/autores");
		ObjectMapper mapper = new ObjectMapper();
		// convierto a texto
		String json = mapper.writeValueAsString(aut);
		// convierto a json
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = client.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		//if (statusCode != 200) {
		//	throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		//}

	}

	@Override
	public void deleteAut(Long id) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete("http://localhost:9090/autores/eliminar/"+id);

		
		httpDelete.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpDelete);
		int statusCode = response.getStatusLine().getStatusCode();
		//if (statusCode != 200) {
			//throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	//	}

	}

	@Override
	public void actualActor(Autor aut) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut("http://localhost:9090/autores");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(aut);
		StringEntity entity = new StringEntity(json);
		httpPut.setEntity(entity);
		httpPut.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpPut);
		int statusCode = response.getStatusLine().getStatusCode();
		//if (statusCode != 200) {
		//	throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		//}

	}

}
