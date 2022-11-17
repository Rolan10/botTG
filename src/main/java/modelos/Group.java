package modelos;

import java.util.ArrayList;

public class Group {


	int id;
	String name;
	ArrayList<Activity> activities;
	
	
	public Group(int id, String name, ArrayList<Activity> activities) {
		super();
		this.id = id;
		this.name = name;
		this.activities = activities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Activity> getActivities() {
		return activities;
	}
	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
	public int calcularPuntos() {
		int puntos = 0;
		for(int i = 0 ; i < activities.size();i++) {
			puntos+=activities.get(i).getPuntos();
		}
		return puntos;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", activities=" + activities + "]";
	}
	
	
}
