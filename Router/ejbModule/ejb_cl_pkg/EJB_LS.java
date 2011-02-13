package ejb_cl_pkg;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.*;
import org.hibernate.cfg.*;



//import parking_pkg.parkingEntity;

import ejb_cl_pkg.GeoCoordinate;
import ejb_cl_pkg.LocalServer;

/**
 * Session Bean implementation class EJB_LS
 * (mappedName = "EJB_LSNamn")
 */
@Stateless
@LocalBean
public class EJB_LS implements EJB_LSRemote, EJB_LSLocal {

	Session session;
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public EJB_LS() {
    }

	public LocalServer GetLocalServer(GeoCoordinate x) {
		session = sf.openSession();
		session.beginTransaction();		
		SDC e = (SDC) session.get(SDC.class, (int)1);
		return new LocalServer(e.getIp());
	}
}
