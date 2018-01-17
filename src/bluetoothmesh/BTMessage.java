/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

import java.util.ArrayList;

/**
 *
 * @author jobmwesigwa
 */
public class BTMessage {
    private String receiver = "";
    private String reciverID = "";
    private int receiverAddress = 0, messageFrequency = 0;
    private long opcode = 0;
    private ArrayList parameters = new ArrayList();

    /**
     *
     */
    public BTMessage() {
    }

    /**
     *
     * @return
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     *
     * @param receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     *
     * @return
     */
    public String getReciverID() {
        return reciverID;
    }

    /**
     *
     * @param reciverID
     */
    public void setReciverID(String reciverID) {
        this.reciverID = reciverID;
    }

    /**
     *
     * @return
     */
//    public String getNetworkID() {
//        return networkID;
//    }

    /**
     *
     * @param networkID
     */
//    public void setNetworkID(String networkID) {
//        this.networkID = networkID;
//    }

    /**
     *
     * @return
     */
    public long getOpcode() {
        return opcode;
    }

    /**
     *
     * @param opcode
     */
    public void setOpcode(long opcode) {
        this.opcode = opcode;
    }

    /**
     *
     * @return
     */
    public ArrayList getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     */
    public void setParameters(ArrayList parameters) {
        this.parameters = parameters;
    }
    
}
