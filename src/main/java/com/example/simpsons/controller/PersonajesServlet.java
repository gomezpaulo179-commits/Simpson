package com.example.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.simpsons.model.Personaje;
import com.example.simpsons.servicio.PersonajeServicio;
import com.example.simpsons.util.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {

    //con spring aprenderemos a inyectar los servicio en los controloradores @autowired!! y no usaremos nerw!!
    private final PersonajeServicio servicio = new PersonajeServicio();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
        response.setContentType("text/html");

    //1. leer parametros del request

    String lugar = request.getParameter("lugar");
    String ordenarPor = request.getParameter("ordenarPor");
    //boolean descendente = request.getParameter("descendente") != null ? Boolean.parseBoolean(request.getParameter("descendente")) : false;
boolean descendente = request.getParameter("descendente") != null; // si no se marca, viaja nulo

        String edadMax = request.getParameter("edadMax");

        String limite = request.getParameter("limite");

        List<Personaje> personajes = new ArrayList<>();
    //2. tratar los parametros. conversiones y validaciones
        try {
            Integer edadMaxInt = Utils.leerEntero("edad maxima", edadMax);
            Integer limiteInt = Utils.leerEntero("numero de personajes maximo a mostrar", limite);
            //3. logica. necesito obtener los personajes de los simpsons
            personajes = servicio.buscar(lugar, edadMaxInt, ordenarPor, descendente, limiteInt);
        } catch (Exception e) {
            //escribir un mensjae de error en personajes.jsp
            request.setAttribute("error", e.getMessage());
        }









    //4. pasar a la vista tod lo que necesite
        request.setAttribute("personajes", personajes);
        request.setAttribute("lugares", servicio.lugaresDisponibles());
    //5. reenviar a la vista (plantilla jsp)
        request.getRequestDispatcher("/WEB-INF/personajes.jsp").forward(request, response);
    }


}