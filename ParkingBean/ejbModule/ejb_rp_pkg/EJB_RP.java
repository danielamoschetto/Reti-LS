package ejb_rp_pkg;

import java.util.Vector;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJB_RP
 */

// RP = richiesta di parcheggio

@Stateless(mappedName = "EJB_RP")
@LocalBean
public class EJB_RP implements EJB_RPRemote, EJB_RPLocal {
	 
	// bean for storing reservation inside db
	@EJB private EJB_SR storeManager;
	
    /**
     * Default constructor. 
     */
    public EJB_RP() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Vector<Parking> getParking() {
		// TODO Auto-generated method stub
		return storeManager.getParking();
	}
	
	public Reservation reserve(Parking p){
		return storeManager.reserve(p);
	}    

}
