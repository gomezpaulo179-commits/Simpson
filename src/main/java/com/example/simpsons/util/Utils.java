package com.example.simpsons.util;

public class Utils {
    /**
     * 
     * @param nombreCampo
     * @param valor
     * @return
     * @throws Exception
     */

    public static Integer leerEntero(String nombreCampo, String valor)throws Exception{
        //1. comprobamos si el valor es nul o vacio
        if (valor == null || valor.isEmpty()){
            return null;
        }

        //comprobamos que el texto se puede convertir a un entero
        Integer numero;
        try {
            numero = Integer.valueOf(valor); // lanza un NumberFormatException
        }catch (Exception e){
            //crear y propagar una excepcion checked generica
            throw  new Exception("el campo " + nombreCampo + "debe ser un numero entero.");
        }

        //comprobamos que no admite negativo
        if(numero <0){
            throw  new Exception("el campo " + nombreCampo + "debe ser un numero entero.");
        }

        return numero;
    }
}
