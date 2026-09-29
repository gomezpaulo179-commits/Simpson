package com.example.simpsons.servicio;

//aqui vive toda la logica de los streams
//el servlet no filtra ni ordena


import com.example.simpsons.model.Personaje;
import com.example.simpsons.repository.PersonajeRepository;

import java.util.List;

public class PersonajeServicio {
    //en spring aprenderemos a usar inyeccion de independencias y no usar new...
    private final PersonajeRepository repositorio = new PersonajeRepository();


    public List<Personaje> buscar(){
    return repositorio.findAll();
    }




}
