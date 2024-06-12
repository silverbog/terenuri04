package terenuri3;

import java.io.IOException;
import java.sql.SQLException;
import terenuri3.Constante;
import com.opensymphony.xwork2.ActionSupport;

public class TerenDeleteAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	/**Declansaza stergerea unui teren*/
	private int id;
	
	public String execute() throws SQLException, ClassNotFoundException, IOException {
		if (TerenDAO.deleteTeren(getId())== 1){
			return Constante.ACTION_SUCCES;
		}
		else {
			return Constante.ACTION_ERROR;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
