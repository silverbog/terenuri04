package terenuri3;

import java.io.IOException;
import java.sql.*;
import terenuri3.Database;
import terenuri3.Teren;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.RowSetDynaClass;
import java.lang.reflect.Field;

public class TerenDAO {
	/**
	 * Toate metodele de acces
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	// private Connection theDbConnection;

	public static RowSetDynaClass listaTerenuri_(String sql) throws SQLException, ClassNotFoundException, IOException {
		// "SELECT TOP 200 * FROM craiova";
		Connection theDbConnection = Database.getTheDbConnection();

		Statement stmt = theDbConnection.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		RowSetDynaClass resultSet = new RowSetDynaClass(rs, false);

		System.out.println("Trec prin terenDAO listaTerenuri(String)");

		return resultSet;

	}

	public static RowSetDynaClass listaTerenuri(String sql, Teren terenCautat, boolean cautareExacta)
			throws SQLException, ClassNotFoundException, IOException {
		/**
		 * Metoda intoarce o lista de terenuri in functie de parametrii de cautare
		 * terenCautat este un teren care are unele atribute completate si care vor
		 * servi ca filtru pentru metoda prezenta SELECT * FROM tabel se completeaza cu
		 * clauze WHERE daca sunt transmise atribute in vehicul terenCautat trebuie sa
		 * permita o cautare exacta si una aproximativa daca e cautare exacta folosim
		 * '=' daca e cautare aproximativa folosim 'LIKE' o sa fac o trecere prin bucla
		 * sa vad cate campuri sunt ne-nule
		 */
		// String sql = "SELECT TOP 200 * FROM " + table;
		String si;

		// if (terenCautat.getNrcadast() != null) {

		Field[] attributes = terenCautat.getClass().getDeclaredFields();
		boolean where = true; // se adauga numai la prima trecere prin loop
		String comparator; // poate avea valorile "=" sau "LIKE"

		if (cautareExacta) {
			comparator = " = ";
			si = " AND ";
		} else {
			comparator = " LIKE ";
			si = " AND ";

		}

		int contor = 0;
		for (Field field_c : attributes) {
			try {
				if (PropertyUtils.getSimpleProperty(terenCautat, field_c.getName()) != null
						&& PropertyUtils.getSimpleProperty(terenCautat, field_c.getName()) != "") {
					contor++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Field field : attributes) {
			/* sql="SELECT * from " + table */
			/**
			 * Pentru ca id e initializat la 0 introdu o conditie de a sari campul id acest
			 * lucru nu permite cautarea dupa id. Daca doresc acest lucru trebuie scoasa
			 * conditia field.getName()).equals("id")
			 */
			try {
				if (field.getName().equals("id") != true) {
					/**
					 * Ramura aceasta evita cautarea dupa id=0 care este instantiat direct la 0
					 * Cautarea e mai complicata, ID este int si nu functioneaza LIKE trebuie "=" se
					 * modifica si conditia de oprire cu contor=0
					 */

					if (PropertyUtils.getSimpleProperty(terenCautat, field.getName()) != null
							&& PropertyUtils.getSimpleProperty(terenCautat, field.getName()) != "") {
						// && !PropertyUtils.getSimpleProperty(terenCautat,
						// field.getName()).equals("id")) {
						/*
						 * System.out.println("ATTRIBUTE NAME: " + field.getName() + " " +
						 * PropertyUtils.getSimpleProperty(terenCautat, field.getName()));
						 */
						if (where) {
							sql = sql.concat(" WHERE ");
							where = false;
						}
						
						sql = sql.concat(field.getName());
						sql = sql.concat(comparator);
						
						if (!cautareExacta) {
							sql = sql.concat("'%");
						} else {
							sql = sql.concat("'");
						}

						sql = sql.concat(PropertyUtils.getSimpleProperty(terenCautat, field.getName()).toString());
						
						if (!cautareExacta) {
							sql = sql.concat("%'");
						} else {
							sql = sql.concat("'");
						}

						contor--;

						/**
						 * testarea cu conditia if (contor > 0) se face in cazul in care se cauta si
						 * dupa ID lucrurile sunt mai complicate pt ca id este un int si nu functioneaza
						 * LIKE
						 */
						// if (contor > 0) {
						if (contor > 1) {
							sql = sql.concat(si);
						}

					}
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		// }
		sql = sql.concat(" LIMIT 200");
		System.out.println(sql);
		return listaTerenuri_(sql);
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 **********************************************************************/

	public static Teren cautTeren(int searchId) throws SQLException, ClassNotFoundException, IOException {
		/**
		 * se presupune ca facem cautarea dupa un index unic si returnez doar prima
		 * valore
		 */
		Teren terenCautat = null;
		Connection theDbConnection = Database.getTheDbConnection();
		String sqlCaut = "SELECT * FROM craiova WHERE id= '" + searchId + "'";

		PreparedStatement stmt = theDbConnection.prepareStatement(sqlCaut);

		ResultSet rs = stmt.executeQuery(sqlCaut);

		if (rs.next()) {
			/**
			 * Daca nu e null se recordsetul se plaseaza pe primul record
			 */
			terenCautat = new Teren(rs.getInt("id"), rs.getString("nrcadast"), rs.getString("nume"),
					rs.getString("str"), rs.getString("nr"), rs.getString("tarla"), rs.getString("parcela"),
					rs.getString("data"), rs.getString("inrg"), rs.getString("ex"), rs.getString("obiect"),
					rs.getString("cf"), rs.getString("dom_public"));
		}

		rs.close();
		stmt.close();

		return terenCautat;

	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 **********************************************************************/

	// public static void insertNewTeren(Teren teren) throws SQLException {
	public static int insertNewTeren(Teren teren) throws SQLException, ClassNotFoundException, IOException {
		/**
		 * introducere a unui nou teren este apelat de TerenInsertAction se trimite prin
		 * POJO terenul nu trebuie sa aiba id
		 */
		int cateInserari = 0;
		Connection theDbConnection = Database.getTheDbConnection();

		String sqlInsert = "INSERT INTO craiova (nrcadast, nume, str, nr, tarla, parcela, data, inrg, ex, obiect, CF, dom_public)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = theDbConnection.prepareStatement(sqlInsert);

		stmt.setString(1, teren.getNrcadast());
		stmt.setString(2, teren.getNume());
		stmt.setString(3, teren.getStr());
		stmt.setString(4, teren.getNr());
		stmt.setString(5, teren.getTarla());
		stmt.setString(6, teren.getParcela());
		stmt.setString(7, teren.getData());
		stmt.setString(8, teren.getInrg());
		stmt.setString(9, teren.getEx());
		stmt.setString(10, teren.getObj());
		stmt.setString(11, teren.getCf());
		stmt.setString(12, teren.getDom_public());

		cateInserari = stmt.executeUpdate();
		stmt.close();
		return cateInserari;

		// System.out.println("A fost inserat TEREN cu succes!"+ teren.toString());

	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 **********************************************************************/

	public static void updateTeren(Teren teren) throws SQLException, ClassNotFoundException, IOException {
		/**
		 * Se actualizeaza datele unui teren se scriu datele in tabela
		 */

		Connection theDbConnection = Database.getTheDbConnection();// static

		String sqlUpdate = "UPDATE craiova SET nrcadast=?, nume=?, str=?, nr=?, tarla=?, parcela=?, data=?, inrg=?, ex=?, obiect=?, CF=?, dom_public=? WHERE id=?";

		System.out.println(sqlUpdate);

		PreparedStatement stmt = theDbConnection.prepareStatement(sqlUpdate);

		stmt.setString(1, teren.getNrcadast());
		stmt.setString(2, teren.getNume());
		stmt.setString(3, teren.getStr());
		stmt.setString(4, teren.getNr());
		stmt.setString(5, teren.getTarla());
		stmt.setString(6, teren.getParcela());
		stmt.setString(7, teren.getData());
		stmt.setString(8, teren.getInrg());
		stmt.setString(9, teren.getEx());
		stmt.setString(10, teren.getObj());
		stmt.setString(11, teren.getCf());
		stmt.setString(12, teren.getDom_public());
		stmt.setInt(13, teren.getId());

		stmt.executeUpdate();
		stmt.close();
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 **********************************************************************/
	public static int deleteTeren(int id) throws SQLException, ClassNotFoundException, IOException {
		/** Stregere teren cu id transmis */
		int cateRecorduri = 0;

		Connection theDbConnection = Database.getTheDbConnection();// static

		String sqlUpdate = "DELETE FROM craiova WHERE id=?";

		PreparedStatement stmt = theDbConnection.prepareStatement(sqlUpdate);

		stmt.setInt(1, id);
		cateRecorduri = stmt.executeUpdate();

		stmt.close();

		return cateRecorduri;
	}

	public static RowSetDynaClass listaTerenuri(String sql) throws SQLException, ClassNotFoundException, IOException {
		/**
		 * Metoda intoarce o lista de terenuri in functie de parametrii de cautare
		 * terenCautat este un teren care are unele atribute completate si care vor
		 * servi ca filtru pentru metoda prezenta SELECT * FROM tabel se completeaza cu
		 * clauze WHERE daca sunt transmise atribute in vehicul terenCautat trebuie sa
		 * permita o cautare exacta si una aproximativa daca e cautare exacta folosim
		 * '=' daca e cautare aproximativa folosim 'LIKE' o sa fac o trecere prin bucla
		 * sa vad cate campuri sunt ne-nule
		 */

		sql = sql.concat(" LIMIT 200");
		System.out.println(sql);
		return listaTerenuri_(sql);
	}

}
