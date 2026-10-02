package com.example.simpsons.servicio;

//aqui vive toda la logica de los streams
//el servlet no filtra ni ordena


import com.example.simpsons.model.Personaje;
import com.example.simpsons.repository.PersonajeRepository;

import java.util.List;

public class PersonajeServicio {
    //en spring aprenderemos a usar inyeccion de independencias y no usar new...
    private final PersonajeRepository repositorio = new PersonajeRepository();


    public List<Personaje> buscar(String lugar,
                                  Integer edadMax,
                                  String ordenarPor, //pendiente
                                  boolean descendente, //pendiente
                                  Integer limite){
    return repositorio.findAll().stream()
            .filter(p -> lugar == null || lugar.isBlank() || p.lugar().equalsIgnoreCase(lugar))
            .filter(p -> edadMax == null || p.edad() > edadMax)
            .sorted((p1, p2) -> p1.nombre().compareTo(p2.nombre()))
            .limit(limite == null ? Integer.MAX_VALUE : limite)
            .toList();
    }
    public List<String> lugaresDisponibles(){
        //forma 1 funcional
        return repositorio.findAll().stream()
                //.map(p -> p.lugar())
                .map(Personaje::lugar).distinct()
                .sorted()
                .toList();
        //forma 2 imperativo

        //forma 3 convierto a set (conjunto no repetido)
    }




}
