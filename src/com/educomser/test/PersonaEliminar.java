package com.educomser.test;

import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PersonaEliminar {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("--  ELIMINAR PERSONA --");
        System.out.println("Ingrese el Id de la persana a eliminar");
        int id = in.nextInt();
        // Instanciamos la clase de acceso a datos
        PersonaDao perDao = new PersonaDaoImpl();
        Persona per = perDao.findById(id);

        if (per != null) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
            System.out.println("Persona encontrada");
            System.out.println("ID:"+per.getId());
            System.out.println("NOMBRE:"+per.getNombre());
            System.out.print("¿Desea eliminar S/N? :");
            
            String resp=in.next().toUpperCase();
            if(resp.contains("S")){
                perDao.delete(per);
                System.out.println("Se ha eliminado correctamente.");
            }
                    
            
        } else {
            
            System.out.println("El ID ingresado no existe.");
        }

    }

}
