/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

/**
 *
 * @author jobmwesigwa
 */
public class BTMessage {
    private Device sender;
    private Device receiver; 
    private int messageFrequency = 0;
    private String message ="";

    public BTMessage(Device sender, Device receiver, int freq, String txt) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageFrequency = freq;
        this.message = txt;
    }
   
    
    /**
     *
     * @return
     */
    public Device getSender() {
        return sender;
    }

    /**
     *
     * @param sender
     */
    public void setSender(Device sender) {
        this.sender = sender;
    }

    public Device getReceiver() {
        return receiver;
    }

    public void setReceiverAddress(Device receiver) {
        this.receiver = receiver;
    }

    public int getMessageFrequency() {
        return messageFrequency;
    }

    public void setMessageFrequency(int messageFrequency) {
        this.messageFrequency = messageFrequency;
    }
    
     /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
