package personal.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import personal.jdbc.datos.FourPersonasDAOImpl;
import personal.jdbc.datos.OneConexion;
import personal.jdbc.datos.ThreePersonasDAO;
import personal.jdbc.entity.TwoPersonaDTO;

public class Test {

	public static void main(String[] args) {

		Connection con = null;

		try {
			con = OneConexion.getConnection();

			if (con.getAutoCommit()) { // Establecer la propiedad autocommit a false, ya que por defecto es true.
				con.setAutoCommit(false);
			}

			ThreePersonasDAO per = new FourPersonasDAOImpl(con);

			/*** PRUEBA SELECT ***/

			List<TwoPersonaDTO> perL = per.select();

			for (TwoPersonaDTO one : perL) {
				System.out.println(one);
			}
			System.out.println();

			/*** PRUEBA UPDATE ***/
			/*
			 * TwoPersonaDTO personaUpdate = new TwoPersonaDTO();
			 * personaUpdate.setId_persona(9); personaUpdate.setNombre("Edgar");
			 * personaUpdate.setApellido("Ojeda"); personaUpdate.setRut("29471852-5");
			 * 
			 * int resultUpdate = per.update(personaUpdate);
			 * System.out.println(resultUpdate);
			 */

			/*** PRUEBA INSERT ***/
			/*
			 * TwoPersona personaInsert = new TwoPersona();
			 * personaInsert.setNombre("Edgar"); personaInsert.setApellido("Ojeda");
			 * personaInsert.setRut("29471852-5");
			 * 
			 * int resultInsert = per.insert(personaInsert);
			 * System.out.println(resultInsert);
			 */

			/*** PRUEBA DELETE ***/
			/*
			 * Persona persona = new Persona(); persona.setId_persona(6);
			 * 
			 * int result = per.delete(persona); System.out.println(result);
			 */

			con.commit();

		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				con.rollback(); // Debe ser envuelta en un try-catch
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
