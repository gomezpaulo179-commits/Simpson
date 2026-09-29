package com.example.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.simpsons.model.Personaje;
import com.example.simpsons.servicio.PersonajeServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {

    //con spring aprenderemos a inyectar los servicio en los controloradores @autowired!! y no usaremos nerw!!
    private final PersonajeServicio servicio = new PersonajeServicio();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

    //1. leer parametros del request

    String lugar = request.getParameter("lugar");
    String ordenarPor = request.getParameter("ordenarPor");
    boolean descendente = request.getParameter("descendente") != null ? Boolean.parseBoolean(request.getParameter("descendente")) : false;


        String edadMax = request.getParameter("edadMax");
        String limite = request.getParameter("limite");

    //2. tratar los parametros. conversiones y validaciones



    //3. logica. necesito obtener los personajes de los simpsons
        List<Personaje> personajes = servicio.buscar();
        request.setAttribute("personajes", personajes);




    //4. pasar a la vista tod lo que necesite
        request.setAttribute("ordenarPor", ordenarPor);
    //5. reenviar a la vista (plantilla jsp)
        request.getRequestDispatcher("/personajes").forward(request, response);
    }


}