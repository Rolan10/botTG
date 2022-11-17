package controladores;

import java.util.ArrayList;

import modelos.Group;

public class Puntos {
	static ArrayList<Group> groups = new ArrayList<Group>();
	static ReadJSON read = new ReadJSON();
	
	
	
	static public void InitList() {
		groups.clear();
		read.InitList(groups);
	}
	
	static public String Mensaje() {
		String s = "";
		
		ArrayList<Group> mensaje = new ArrayList<Group>();
		mensaje.add(groups.get(0));
		for(int i=0;i < groups.size(); i++) {
			
			if(mensaje.get(0).calcularPuntos() ==  groups.get(i).calcularPuntos()) {
				
				mensaje.add(groups.get(i));
			}
			if(mensaje.get(0).calcularPuntos() < groups.get(i).calcularPuntos()) {
				mensaje.clear();
				mensaje.add(groups.get(i));
			}
			
		}int ini=0;
		for(int i = 0; i < mensaje.size();i++) {
		
			if(mensaje.size()>1&& ini==0) {
				s+="Empates entre: \n ";
				ini++;
			}else if(ini==0){
			s+="Los que van en cabeza son: ";}
			s+= mensaje.get(i).getName()+" con "+ mensaje.get(i).calcularPuntos() +" puntos \n";
		}
		
		return s;
	}
	
	static public void main(String [] args) {
		
		InitList();
		System.out.println(Mensaje());
	}
}
