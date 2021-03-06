/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

/**
 *
 * @author Fabio
 */
public class ClientMessage {
    private String msg;
    private Boolean routerStatus;
    private Boolean JMSStatus;

    public ClientMessage(String text) {
    	msg=text;
    	JMSStatus = null;
    	routerStatus = null;
	}

	@Override
    public String toString(){
        return msg;
    }

    public Boolean getJMSStatus() {
        return JMSStatus;
    }

    public void setJMSStatus(Boolean JMSStatus) {
        this.JMSStatus = JMSStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getRouterStatus() {
        return routerStatus;
    }

    public void setRouterStatus(Boolean routerStatus) {
        this.routerStatus = routerStatus;
    }

    void setAll(String string, boolean router, boolean jms) {
        msg = string;
        routerStatus = router;
        JMSStatus = jms;
    }
    
}
