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
    private int senderAddress = 0;
    private int receiverAddress = 0; 
    private int messageFrequency = 0;
    private int hopes =0;
    private int TIME_TO_LIVE = 0;
    private String message ="";
    /**
     *
     */
    public BTMessage() {
    }

    /**
     *
     * @return
     */
    public int getSenderAddress() {
        return senderAddress;
    }

    /**
     *
     * @param reciverID
     */
    public void setReciverID(int senderAddress) {
        this.senderAddress = senderAddress;
    }

    public int getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(int receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public int getMessageFrequency() {
        return messageFrequency;
    }

    public void setMessageFrequency(int messageFrequency) {
        this.messageFrequency = messageFrequency;
    }

    public int getTIME_TO_LIVE() {
        return TIME_TO_LIVE;
    }

    public void setTIME_TO_LIVE(int TIME_TO_LIVE) {
        this.TIME_TO_LIVE = TIME_TO_LIVE;
    }
    
    
}
