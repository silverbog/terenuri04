package terenuri3;

import java.io.IOException;
import java.sql.SQLException;
import terenuri3.Constante;
import com.opensymphony.xwork2.ActionSupport;

public class TerenInsertAction extends ActionSupport {
	/**Cand se pune problema inserarii unui teren 
	 * nu trebuie sa inserez nimic in campul ID din baza de  date
	 * Acest lucru il controlez prin actiunea Insert si TerenDAO.insert*/
	private static final long serialVersionUID = 1927662980043728608L;
	
	private Teren teren;
	

	/**constructor fara parametrii*/ 
	public TerenInsertAction() {
		//Folosesc constructor care nu are ID
		this.teren=new Teren();
	}
	
	public TerenInsertAction(Teren teren) {
		this.setTeren(teren);
	}


//	public String execute (Teren unTeren) throws SQLException{
	public String execute () throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Trec prin TerenInsertAction.execute");

		if (TerenDAO.insertNewTeren(teren) > 0 ){
			return Constante.ACTION_SUCCES;
		}else{
			return Constante.ACTION_ECHEC;
		}
				
	}

	public Teren getTeren() {
		return teren;
	}

	public void setTeren(Teren teren) {
		this.teren = teren;
	}




}
