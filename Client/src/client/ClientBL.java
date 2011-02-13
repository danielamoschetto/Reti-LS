/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import ejb_cl_pkg.EJB_ROUTERRemote;
import ejb_cl_pkg.GeoCoordinate;
import ejb_cl_pkg.LocalServer;

import java.util.Observable;
import java.util.Properties;
import javax.naming.*;

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
		EJB_ROUTERRemote bean;

		bean = (EJB_ROUTERRemote) ctx.lookup("EJB_CLName");
		LS = bean.GetLocalServer(position);
}

	@Override
	public void run() {
		try {
			GetLocalServer();
			msg.setAll("\nClientBL: \nConnected with server" + id, true, false);
			setChanged();
			notifyObservers(msg);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			msg.setAll("\nClientBL: \nFail Connection with server" + id, false, false);
			setChanged();
			notifyObservers(msg);
		}

	}

}
