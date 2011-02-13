/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import ejb_cl_pkg.EJB_CLRemote;
import ejb_cl_pkg.GeoCoordinate;
import ejb_cl_pkg.LocalServer;
import ejb_rp_pkg.EJB_RPRemote;

import java.io.FileInputStream;
import java.net.InetAddress;

import java.util.Observable;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author Fracido
 */
public class ClientBL extends Observable implements Runnable {

	String RouterIP;
	LocalServer LS;
	ClientMessage msg;
	String id;
	GeoCoordinate position;

	ClientBL(String clientName, String ipRouter, double latitude,
			double longitude) {
		this.id = clientName;
		this.RouterIP = ipRouter;
		this.position = new GeoCoordinate(latitude, longitude);
		msg = new ClientMessage("");
	}

	public void GetLocalServer() throws Exception {

		InitialContext ctx = null;
		Properties props = new Properties();

		props.loadFromXML(getClass().getResource("/client/resources/EJBconn.xml").openStream());
		ctx = new InitialContext(props);
		EJB_CLRemote bean;

		bean = (EJB_CLRemote) ctx.lookup("EJB_CLName");
		LS = bean.GetLocalServer(position);
		
		/*
		Properties props2 = props;
		props2.setProperty("org.omg.CORBA.ORBInitialHost", "daniela");
		InitialContext ctx2 = new InitialContext(props2);
		 EJB_RPRemote bean2 = (EJB_RPRemote) ctx.lookup("EJB_RP");
		 bean2.getParking();
		 */
}

	@Override
	public void run() {
		try {
			GetLocalServer();
			msg.setAll("Connected with server" + id, true, false);
			setChanged();
			notifyObservers(msg);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			msg.setAll("Fail Connection with server" + id, false, false);
			setChanged();
			notifyObservers(msg);
		}

	}

}
