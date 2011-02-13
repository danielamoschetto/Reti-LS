package ejb_rp_pkg;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Parking implements Serializable{
	private int id,totspot,availablespot,status;
	private String name,address,city;
	private double latitude,longitude;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotspot() {
		return totspot;
	}
	public void setTotspot(int totspot) {
		this.totspot = totspot;
	}
	public int getAvailablespot() {
		return availablespot;
	}
	public void setAvailablespot(int availablespot) {
		this.availablespot = availablespot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	

}
