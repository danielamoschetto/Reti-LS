package ejb_cl_pkg;
import javax.ejb.Remote;

@Remote
public interface EJB_CLRemote {
	public LocalServer GetLocalServer(GeoCoordinate x);
}
