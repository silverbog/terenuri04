package terenuri3;

import java.sql.SQLException;
import terenuri3.Constante;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TerenDetaliiAction extends ActionSupport {
	
	private int id=0;
	private Teren teren=null;
	
	public TerenDetaliiAction() throws SQLException {
		
	}
	
	public String execute() throws Exception {
		this.teren	=TerenDAO.cautTeren(id);
		
		return Constante.ACTION_SUCCES;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teren getTeren() {
		return teren;
	}

	public void setTeren(Teren teren) {
		this.teren = teren;
	}
	
	


	



}
