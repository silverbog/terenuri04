package terenuri3;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
		private Teren teren=null;
		
		public TestAction() {
			
		}

		public String execute() {
			this.teren=new Teren(1,"2","3","4","5","6","7","8","9","10","11","12","13");
			return "success";
		}
		
		/**
		 * @return the teren
		 */
		public Teren getTeren() {
			return teren;
		}

		/**
		 * @param teren the teren to set
		 */
		public void setTeren(Teren teren) {
			this.teren = teren;
		}
		

}
