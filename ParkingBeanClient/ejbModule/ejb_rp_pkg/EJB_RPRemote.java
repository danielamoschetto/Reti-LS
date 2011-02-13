package ejb_rp_pkg;
import java.util.Vector;

import javax.ejb.Remote;

@Remote
public interface EJB_RPRemote {

	public Vector<Parking> getParking();
	public Reservation reserve(Parking p);
}
