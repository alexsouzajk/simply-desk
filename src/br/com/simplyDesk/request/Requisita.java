package br.com.simplyDesk.request;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class Requisita {
	
	public static String get(String url) {
		Gson gson = new Gson();

		String jsonRetorno = null;
		try {
			OkHttpClient client = new OkHttpClient();

			Request.Builder builder = new Request.Builder();

			builder.url(url);

			Request request = builder.build();

			Response response = client.newCall(request).execute();

			jsonRetorno = response.body().string();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: \n"+e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return jsonRetorno;
	}
	
	public static String put(String url, Object objetoRequest) {
		Gson gson = new Gson();

		String json = gson.toJson(objetoRequest);
		String jsonRetorno = null;
		try {
			OkHttpClient client = new OkHttpClient();

			Request.Builder builder = new Request.Builder();

			builder.url(url);

			MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
			
			RequestBody body = RequestBody.create(mediaType, json);
			
			builder.put(body);

			Request request = builder.build();

			Response response = client.newCall(request).execute();

			jsonRetorno = response.body().string();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: \n"+e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return jsonRetorno;
	}
	
	public static String delete(String url, Object objetoRequest) {
		Gson gson = new Gson();

		String json = gson.toJson(objetoRequest);
		String jsonRetorno = null;
		try {
			OkHttpClient client = new OkHttpClient();

			Request.Builder builder = new Request.Builder();

			builder.url(url);

			MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
			
			RequestBody body = RequestBody.create(mediaType, json);
			
			builder.delete(body);

			Request request = builder.build();

			Response response = client.newCall(request).execute();

			jsonRetorno = response.body().string();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: \n"+e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return jsonRetorno;
	}
	

	public static String post(String url, Object object) {
		Gson gson = new Gson();
		
		String json = gson.toJson(object);
		String jsonRetorno = null;
		try {
			OkHttpClient client = new OkHttpClient();

			Request.Builder builder = new Request.Builder();

			builder.url(url);

			MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
			
			RequestBody body = RequestBody.create(mediaType, json);
			
			builder.post(body);

			Request request = builder.build();

			Response response = client.newCall(request).execute();

			jsonRetorno = response.body().string();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: \n"+e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return jsonRetorno;
	}
	
}
