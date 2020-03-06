package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculasService {
	
	private List<pelicula> lista= null;
	
	public PeliculaServiceImpl() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();
			
			pelicula pelicula1=new pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-03-2020"));
			// imagen = cinema.jpg
			// estatus = activa
			
			pelicula pelicula2=new pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("IT 2");
			pelicula2.setDuracion(180);
			pelicula2.setClasificacion("C");
			pelicula2.setGenero("Terror");
			pelicula2.setFechaEstreno(formatter.parse("05-03-2020"));
			pelicula2.setImagen("it2.jpg");
			
			pelicula pelicula3=new pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("La era del hielo 19");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("A");
			pelicula3.setGenero("Aventura");
			pelicula3.setFechaEstreno(formatter.parse("03-03-2020"));
			pelicula3.setImagen("qwea.jpg");

			
			pelicula pelicula4=new pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("En este Rincón del Mundo");
			pelicula4.setDuracion(130);
			pelicula4.setClasificacion("A");
			pelicula4.setGenero("Drama");
			pelicula4.setFechaEstreno(formatter.parse("12-03-2020"));
			pelicula4.setImagen("estreno1.png");
			pelicula4.setEstatus("Inactiva");
			
			pelicula pelicula5=new pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: vida inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("12-03-2020"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Inactiva");
			
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
				
		}catch (java.text.ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	@Override
	public List<pelicula> buscarTodas() {
		return lista;
	}
	
	

}
