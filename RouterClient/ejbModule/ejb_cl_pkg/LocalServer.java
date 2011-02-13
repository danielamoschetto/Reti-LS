package ejb_cl_pkg;

import java.io.Serializable;

public class LocalServer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4434684125961842249L;
	private String name;

	public LocalServer(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
