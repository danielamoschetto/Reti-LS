package ejb_cl_pkg;

import java.io.Serializable;

public class GeoCoordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8438956117767976530L;
	public double latitude;
	public double longitude;

	
	public GeoCoordinate(double latitude, double longitute) {
		// TODO Auto-generated constructor stub
		this.latitude = latitude;
		this.longitude = longitute;
	}
	
}
