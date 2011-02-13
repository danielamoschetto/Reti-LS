package client;

import java.beans.XMLDecoder;
import java.io.InputStream;
import java.util.ArrayList;

import org.hibernate.validator.util.GetClassLoader;

import consumer.JMSManager;
import ejb_cl_pkg.LocalServer;

public class Main {

	static InputStream clientStream;
	
	public Main() throws Exception{
		
		clientStream =  getClass().getResource("/client/resources/CLIENTS.xml").openStream();
	}
	
	
    public static void main(String[] args) throws Exception {

    	new Main();	
        GuiFrame gg = new GuiFrame();
        
        XMLDecoder decoder = new XMLDecoder(clientStream);
        SystemConfig config = (SystemConfig) decoder.readObject();

        //ArrayList<ClientBL> clientBL = new ArrayList<ClientBL>(config.getNumClient());
        //ArrayList<ClientRP> clientRP = new ArrayList<ClientRP>(config.getNumClient());
        ArrayList<Client> client = new ArrayList<Client>(config.getNumClient());
        ArrayList<monitor> m = gg.getMonitorArrayList();

        ClientConfig tmp;

        for (int i = 0; i < config.getNumClient(); i++) {
            tmp = (ClientConfig) decoder.readObject();
            client.add(new Client(""+i,config.getIpRouter(),tmp.getLatitude(),tmp.getLongitude()));
            //clientRP.add(new ClientRP(""+i, "5.67.49.99"));
            m.get(i).setClientId("" + i);
            client.get(i).addObserver(m.get(i));
            //clientRP.get(i).addObserver(m.get(i));
            new Thread(client.get(i)).start();
            //new Thread(clientRP.get(i)).start();
        }
        
        gg.setVisible(true);

        JMSManager ms = new JMSManager(new LocalServer("5.67.49.99"));
        ms.AdvCons.addObserver(m.get(0));
        ms.AdvCons.addObserver(m.get(1));
    }
}
