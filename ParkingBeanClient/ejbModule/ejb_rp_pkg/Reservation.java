package ejb_rp_pkg;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Reservation implements Serializable{
	private int id,parkingid,pnr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParkingid() {
		return parkingid;
	}

	public void setParkingid(int parkingid) {
		this.parkingid = parkingid;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
}
