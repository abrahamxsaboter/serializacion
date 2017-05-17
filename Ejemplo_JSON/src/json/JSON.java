/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author abrahamxsaboter
 */


public class JSON {
    public static void main (String args[]){
        
        Gson gson = new Gson();
       
        //CONVERTIMOS DE JAVA A JSON
        //crearemos los objetos de varios alumnos
        ArrayList alumnos = new ArrayList();
        Alumno alum1=new Alumno("Alberto Abraham",2,'A',100);
        Alumno alum2=new Alumno("Edith Perez",3,'B',95);
        Alumno alum3=new Alumno("Hola mundo",1,'A',70);
        //agregamos los alumnos a una lista
        alumnos.add(alum1);
        alumnos.add(alum2);
        alumnos.add(alum3);
        //convertimos la lista de alumnos a formato JSON
        String formatoJSON = gson.toJson(alumnos);
        //imprimimos en consola el texto con formato JSON
        System.out.println("Texto en Formato JSON:\n"+formatoJSON);

    


        //CONVERTIMOS DE JSON A JAVA
        //Guardamos en una lista los alumnos leidos desde la cadena en formato JSON
        //primero necesitaremos tener el tipo de objeto donde guardaremos la informacion que sera una lista de alumnos
        //despues en gson.gromjson los dos parametros son: la cadena en formato JSON donde leeras la informacion
        //y el tipo de clase/objeto donde guardaras la informacion
        Type tipoObjeto = new TypeToken(){}.getType();
		ArrayList alumnos2=gson.fromJson(formatoJSON, tipoObjeto);
		System.out.println("\nJSON A JAVA:");
		for(int i=0;i<alumnos2 .size();i++){
		 Alumno al = (Alumno) alumnos2.get(i);
		 System.out.println(al.nombre+":"+al.grado+":"+al.grupo+":"+al.calificacion);
		}
    }   
}
