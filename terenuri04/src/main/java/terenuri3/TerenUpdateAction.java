package terenuri3;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class TerenUpdateAction extends ActionSupport {
	private static final long serialVersionUID = -3035636401579865643L;
/**actiunea UPDATE
 * Scriu in campuri valorile introduse in pagina JSP*/
	
	private Teren teren;
	private int id=0;

	// constructor
	public TerenUpdateAction(Teren teren) {
		this.setTeren(teren); 
	}
	
	public TerenUpdateAction() {
		this.setTeren(new Teren());
	}

	public String execute() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Trec prin TerenUpdateAction.execute");
		TerenDAO.updateTeren(teren);

		return terenuri3.Constante.ACTION_SUCCES;
	}

	public Teren getTeren() {
		return teren;
	}

	public void setTeren(Teren teren) {
		this.teren = teren;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




}
