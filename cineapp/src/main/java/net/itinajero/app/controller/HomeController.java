package net.itinajero.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.pelicula;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;


@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	
	//@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping(value="/home")
	public String goHome(){
		return "home";
	}
	
	
	//@RequestMapping(value="/search", method=RequestMethod.POST)
	@PostMapping(value="/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		
		List<String> listaFechas= Utileria.getNextDays(4);
		
		List<pelicula> peliculas = getLista();
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		
		System.out.println("Buscando todas las peliculas en exibicion para la fecha "+fecha);
		return "home";
	}
	
	
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping(value="/")
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas= Utileria.getNextDays(4);
		System.out.println(listaFechas);
		
		List<pelicula> peliculas = getLista();
		/*
		peliculas.add("Rapido y fugioso");
		peliculas.add("La era del hielito");
		peliculas.add("Terminator");
		*/
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
	
	//@RequestMapping(value="/save" , method=RequestMethod.POST)
	@PostMapping(value="/save")
	public String guardar(@RequestParam("titulo") String titulo) {
		System.out.println("Titulo: "+titulo);
		return "detalle";
	}
	
	
	//@RequestMapping(value= "/detail/{id}/{fecha}", method=RequestMethod.GET)
	//@RequestMapping(value= "/detail", method=RequestMethod.GET)
	@GetMapping(value="/detail")
	//public String mostrarDetalle(Model model,@PathVariable("idMovie") int idPelicula,@PathVariable("fecha") String fecha) {
	public String mostrarDetalle(Model model,@RequestParam("idMovie") int idPelicula,@RequestParam("fecha") String fecha) {
				
		System.out.println("PathVariable: "+ idPelicula);
		System.out.println("Horarios pelicula "+ fecha);
		
		
		// TODO - buscar en la base de datos los horarios
		/*
			
		String tituloPelicula = "Rapidos y furiosos 8";
		int duracion=136;
		double precioEntrada=50;
		*/
		
		return "detalle";	
	}
	
	private List<pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<pelicula> lista= null;
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
			
			return lista;		
		}catch (java.text.ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}
