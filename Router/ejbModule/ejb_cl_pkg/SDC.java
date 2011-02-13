package ejb_cl_pkg;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SDC implements Serializable{
	private int id;
	private String ip;
	private String name;
	private String status;
	private int mirror;
	private double latitude;
	private double longitude;
	private String load;
	
	public SDC() {
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMirror() {
		return mirror;
	}

	public void setMirror(int mirror) {
		this.mirror = mirror;
	}

	public void setLoad(String load) {
		this.load = load;
	}

	public String getLoad() {
		return load;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return latitude;
	}

}