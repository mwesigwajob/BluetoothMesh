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
    /**
     * 
     * @param sender source node
     * @param receiver destination node
     * @param freq frequency of the message
     * @param txt the payload 
     */
    public BTMessage(Device sender, Device receiver, int freq, String txt) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageFrequency = freq;
        this.message = txt;
    }
    /**
     * 
     * @return sender the source node
     */
    public Device getSender() {
        return sender;
    }
    /**
     *
     * @param sender the source node
     */
    public void setSender(Device sender) {
        this.sender = sender;
    }
    
    /**
     * 
     * @return receiver the destination node
     */
    public Device getReceiver() {
        return receiver;
    }
    /**
     * 
     * @return messageFrequency
     */
    public int getMessageFrequency() {
        return messageFrequency;
    }
    /**
     * 
     * @param messageFrequency 
     */
    public void setMessageFrequency(int messageFrequency) {
        this.messageFrequency = messageFrequency;
    }
     /**
     * @return the payload
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the payload
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
