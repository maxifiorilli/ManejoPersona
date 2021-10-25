/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejopersonacapadatos;

import java.sql.SQLException;
import java.util.List;
import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

/**
 *
 * @author Maxi
 */
public class TestPersonas {

    
    public static void main(String[] args) {
        //Utilizamos el tipo interface como referencia
        //a una clase concreta
        PersonaDao personaDao= new PersonaDaoJDBC();
        
        //Creamos un nuevo registro
        //Hacemos uso de la clase persona DTO la cual se usa
        //para trasferir la informacion entre las capas.
        //No es necesario especificar la llave primaria
        //ya que en este caso es de tipo autonumerico y la BBDD se encarga
        //de asignarle un nuevo valor
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Mario");
        persona.setApellido("Lopezcito");
        //utilizaremos la capa DAO para persistir el objeto DTO
        try{
            //personaDao.insert(persona);
            
            //eliminaremos un registro, el id 3
            //personaDao.delete(new PersonaDTO(3));
            
            //actualizaremos un registro
            PersonaDTO personaTmp=new PersonaDTO();
            //personaTmp.setId_persona(2);//actualizaremos el registro 2
            //personaTmp.setNombre("Mario");
            //personaTmp.setApellido("Lopez2");
            //personaDao.update(personaTmp);
           
            //Seleccionaremos todos los registros
            List<PersonaDTO>personas= personaDao.select();
            for (PersonaDTO personaDTO:personas){
                System.out.print(personaDTO);
                System.out.println();
            }
        }catch (SQLException e){
        System.out.println("Excepcion en la capa de prueba");
        e.printStackTrace();
    }

    }
    
}
