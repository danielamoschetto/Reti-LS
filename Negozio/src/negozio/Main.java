package negozio;

import javax.naming.InitialContext;
import java.io.FileInputStream;
import java.util.Properties;

import ejb_cl_pkg.*;

public class Main {

	public static LocalServer GetLocalServerFrom(String ServerIp) {
		InitialContext ctx;
		Properties props;
		LocalServer LS = null;
		try {
			props = new Properties();
			props.loadFromXML(new FileInputStream("EJBconn.xml"));
			ctx = new InitialContext(props);
				
			EJB_ROUTERRemote bean = (EJB_ROUTERRemote) ctx.lookup("EJB_ROUTER");			
		
			// Roma Colosseo
			LS = bean.GetLocalServer(new GeoCoordinate(41.8899993896484,12.4921998977661));
			 
			
			
		} catch (Exception ne) {
			System.out.println("Errore: " + ne.getMessage());
		}
		return LS;
	}
	
	
	
	public static void main(String[] args) throws Exception{

		NegozioGui gui = new NegozioGui();
		gui.setVisible(true);
		
		JMSproducer prod = new JMSproducer(new LocalServer("5.67.58.136"));
		prod.addObserver(gui);
		
		new Thread(prod).start();
		
		//LocalServer LS = GetLocalServerFrom("192.168.0.108");
		
		
	}

 

}
