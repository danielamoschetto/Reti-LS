package ejb_cl_pkg;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class EJB_CL
 */
@Stateless(mappedName = "EJB_CLName")
@LocalBean
public class EJB_CL implements EJB_CLRemote, EJB_CLLocal {

	@EJB private EJB_LS ejbLs;
	
	/**
     * Default constructor. 
     */
    public EJB_CL() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public LocalServer GetLocalServer(GeoCoordinate x) {
		return ejbLs.GetLocalServer(x);
		
	}
}
