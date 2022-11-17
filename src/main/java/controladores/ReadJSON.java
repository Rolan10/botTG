package controladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import modelos.Activity;
import modelos.Group;

public class ReadJSON {

	
	

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	public static ArrayList<Group> InitList(ArrayList<Group> lista){
		
		JSONObject json = new JSONObject();
		try {
			json = readJsonFromUrl(
					"https://raw.githubusercontent.com/danibanez/bootcampsolera/main/src/data/teamdata.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(json.toString());
		JSONArray iterable = json.getJSONArray("teamdata");

		for (int i = 0; i < iterable.length(); i++) {
			JSONArray acti=((JSONObject)iterable.get(i)).getJSONArray("actividades");
			ArrayList<Activity> actividades = new ArrayList<Activity>();
			for(int j = 0; j < acti.length();j++) {
				
				actividades.add(new Activity(((JSONObject)acti.get(j)).getString("name"),
						((JSONObject)acti.get(j)).getInt("puntos")));
				
			}
			
			// System.out.println(iterable.get(i).toString());
			int id=	((JSONObject)iterable.get(i)).getInt("id");
			String name=((JSONObject)iterable.get(i)).getString("name");
			
			lista.add(new Group(id,name,actividades));
			
		
		}
		return lista;
		
	}
	public static void main(String[] args) { // O(n^2) :)
//		JSONObject json = new JSONObject();
//		try {
//			json = readJsonFromUrl(
//					"https://raw.githubusercontent.com/Rolan10/bootcampsolera/main/src/data/teamdata.json");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// System.out.println(json.toString());
//		JSONArray iterable = json.getJSONArray("teamdata");
//
//		for (int i = 0; i < iterable.length(); i++) {
//			JSONArray acti=((JSONObject)iterable.get(i)).getJSONArray("actividades");
//			ArrayList<Activity> actividades = new ArrayList<Activity>();
//			for(int j = 0; j < acti.length();j++) {
//				
//				actividades.add(new Activity(((JSONObject)acti.get(j)).getString("name"),
//						((JSONObject)acti.get(j)).getInt("puntos")));
//				
//			}
//			
//			// System.out.println(iterable.get(i).toString());
//			int id=	((JSONObject)iterable.get(i)).getInt("id");
//			String name=((JSONObject)iterable.get(i)).getString("name");
//			
//			groups.add(new Group(id,name,actividades));
//			
//		
//		}
//		
//		for(int k = 0; k < groups.size();k++) {
//			System.out.println(groups.get(k).toString());
//		}
	}

}
