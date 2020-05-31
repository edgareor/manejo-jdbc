package personal.jdbc.datos;

import java.sql.SQLException;
import java.util.List;

import personal.jdbc.entity.TwoPersonaDTO;

public interface ThreePersonasDAO {

	public List<TwoPersonaDTO> select() throws SQLException;

	public int insert(TwoPersonaDTO per) throws SQLException;

	public int update(TwoPersonaDTO per) throws SQLException;

	public int delete(TwoPersonaDTO per) throws SQLException;

}
