package terenuri3;

public class Teren {
	/**
	 * Reprezinta un teren
	 * @autor B.Pauna
	 * @versiunea 1.0
	 * @since 2020.06.15
	 */
	//private int id=0;
	private int id;
	//private int id;
	private String nrcadast = null;
	private String nume = null;
	private String str = null;
	private String nr = null;
	private String tarla = null;
	private String parcela = null;
	private String data = null;
	private String inrg = null;
	private String ex = null;
	private String obj = null;
	private String cf = null;
	private String dom_public = null;
	
	public Teren() {
		/**Constructor fara parametrii*/
	}

	public Teren(String nrcadast, String nume, String str, String nr, String tarla, String parcela, String data,
			String inrg, String ex, String obiect, String CF, String dom_public) {
		/** Constructor folosit la INSERT Nu are ID
		 */
		this.setNrcadast(nrcadast); // 1
		this.setNume(nume);// 2
		this.setStr(str); // 3
		this.setNr(nr);// 4
		this.setTarla(tarla);// 5
		this.setParcela(parcela); // 6
		this.setData(data); // 7
		this.setInrg(inrg); // 8
		this.setEx(ex); // 9
		this.setObj(obiect); // 10
		this.setCf(CF); // 11
		this.setDom_public(dom_public); // 12
	}

	public Teren(int id, String nrcadast, String nume, String str, String nr, String tarla, String parcela, String data,
			String inrg, String ex, String obiect, String CF, String dom_public) {
		/** Constructor folosit la UPDATE ARE ID
		 * face apel la constructorul fara id
		 */
		this(nrcadast, nume, str, nr, tarla, parcela, data, inrg, ex, obiect, CF, dom_public);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNrcadast() {
		return nrcadast;
	}

	public void setNrcadast(String nrcadast) {
		this.nrcadast = nrcadast;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getTarla() {
		return tarla;
	}

	public void setTarla(String tarla) {
		this.tarla = tarla;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInrg() {
		return inrg;
	}

	public void setInrg(String inrg) {
		this.inrg = inrg;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getDom_public() {
		return dom_public;
	}

	public void setDom_public(String dom_public) {
		this.dom_public = dom_public;
	}

	@Override
	public String toString() {
		//final String CR=System.lineSeparator();
		final String BR="<br>";
		final String T="<table>";
		final String TF="</table>";
		final String TD="<TD>";
		final String TDS="</TD>";
		
		/*
		return BR+"Nr CAD=" + nrcadast +BR+"Nume=" + nume +BR+"Strada=" + str + BR+"Nr=" + nr + BR+"Tarla=" + tarla
				+ BR+"Parcela=" + parcela + BR+"Data=" + data + BR+"Nr Inreg=" + inrg +BR+ "Expert=" + ex +BR+ "Obj=" + obj + BR+"C.F.="
				+ cf + BR+"Domeniu public=" + dom_public ;
		*/
		
		return "<table>"+
				"<tr><td>"+"Nr CAD="+"</TD><TD>"+ nrcadast+"</TD></TR>"+
				"<tr><td>"+"Nume="+"</TD><TD>" + nume +"</TD></TR>"+
				"<tr><td>"+"Strada="+"</TD><TD>"  + str +"</TD></TR>"+
				"<tr><td>"+"Nr="+"</TD><TD>"  + nr +"</TD></TR>"+
				"<tr><td>"+"Tarla=" +"</TD><TD>" + tarla+"</TD></TR>"+
				"<tr><td>"+"Parcela=" +"</TD><TD>" + parcela +"</TD></TR>"+
				"<tr><td>"+"Data=" +"</TD><TD>" + data +"</TD></TR>"+
				"<tr><td>"+"Nr Inreg=" +"</TD><TD>" + inrg +"</TD></TR>"+
				"<tr><td>"+"Expert=" +"</TD><TD>" + ex  +"</TD></TR>"+
				"<tr><td>"+"Obj=" +"</TD><TD>" + obj +"</TD></TR>"+
				"<tr><td>"+"C.F.="+"</TD><TD>" + cf +"</TD></TR>"+
				"<tr><td>"+"Domeniu public="+"</TD><TD>"  + dom_public +"</TD></TR>"+
				"</table>";

		
	}
	

}
