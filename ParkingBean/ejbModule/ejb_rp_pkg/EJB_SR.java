package ejb_rp_pkg;

import java.util.List;
import java.util.Vector;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Session Bean implementation class EJB_SR
 */
@Stateless
@LocalBean
public class EJB_SR implements EJB_SRRemote, EJB_SRLocal {

    /**
     * Default constructor. 
     */
    public EJB_SR() {
        // TODO Auto-generated constructor stub
    }
    Session session;
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public Vector<Parking> getParking() {
		session = sf.openSession();
		session.beginTransaction();		
		@SuppressWarnings("unchecked")
		List<Parking> parklist = session.createSQLQuery("SELECT {Parking} FROM PARKING")
			.addEntity("Parking",Parking.class).list();
		return new Vector<Parking>(parklist);
	}
	
	public Reservation reserve(Parking p){
		session = sf.openSession();
		session.beginTransaction();
		Reservation r  = new Reservation();
		r.setParkingid(p.getId());
		session.save(r);
		
		@SuppressWarnings("unchecked")
		List<Reservation> reslist = session.createSQLQuery("SELECT MAX(id) FROM RESERVATION")
		.addEntity("Reservation",Reservation.class).list();
		return reslist.get(0);
	}
}



