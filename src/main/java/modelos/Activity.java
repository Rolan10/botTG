package modelos;

public class Activity {

	String name;
	int puntos;
	
	
	public Activity(String name, int puntos) {
		super();
		this.name = name;
		this.puntos = puntos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Activity [name=" + name + ", puntos=" + puntos + "]";
	}
	
}
