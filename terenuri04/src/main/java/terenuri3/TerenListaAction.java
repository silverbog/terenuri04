package terenuri3;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.RowSetDynaClass;

import com.opensymphony.xwork2.ActionSupport;

public class TerenListaAction extends ActionSupport {
	private static final long serialVersionUID = 2L;
	//
	private TerenListaAction  dto=null;
	private Teren unTeren;
	private List<TerenListaAction> terenList=null;
	private Teren caut;
	private RowSetDynaClass listaTerenuri;
	private boolean cautareExacta;
	
	
	/**
	 *
	 */
	@SuppressWarnings("unused")
	@Override
	public String execute() throws Exception {
		/**
		 * Se instantiaza o lista de obiecte TEREN
		 * Se exploreaza recordsetul transmis prin ????
		 * pentru fiecare element al rs se creeaza un element 
		 * elementul se adauga la lista
		 * */
		//ResultSet rs = null;
		//terenList = new ArrayList<TerenListaAction>();
		
		String sql = "SELECT * FROM craiova ";
		
//		listaTerenuri=TerenDAO.listaTerenuri(sql, caut, false);
		listaTerenuri=TerenDAO.listaTerenuri(sql, caut, this.cautareExacta);
		
		System.out.println("Trec prin TerenListAction");
		
		return SUCCESS;
	}



	public boolean isCautareExacta() {
		return cautareExacta;
	}



	public void setCautareExacta(boolean cautareExacta) {
		this.cautareExacta = cautareExacta;
	}



	public TerenListaAction getDto() {
		return dto;
	}

	public void setDto(TerenListaAction dto) {
		this.dto = dto;
	}

	public Teren getUnTeren() {
		return unTeren;
	}

	public void setUnTeren(Teren unTeren) {
		this.unTeren = unTeren;
	}

	public List<TerenListaAction> getTerenList() {
		return terenList;
	}

	public void setTerenList(List<TerenListaAction> terenList) {
		this.terenList = terenList;
	}

	public Teren getCaut() {
		return caut;
	}

	public void setCaut(Teren caut) {
		this.caut = caut;
	}

	public RowSetDynaClass getListaTerenuri() {
		return listaTerenuri;
	}

	public void setListaTerenuri(RowSetDynaClass listaTerenuri) {
		this.listaTerenuri = listaTerenuri;
	}




}
