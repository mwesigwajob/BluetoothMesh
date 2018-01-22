/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jobmwesigwa
 */
public class Network {
    //Device rootDevice = new Device("123456");
    ArrayList<Device> network = new ArrayList();
    int counter =0;
    
    /**
     * Adds the new device to the network arraylist and adds its reference to 
     * devices connected to it
     * @param newDev the new device to be added
     * @param preds addresses to the new node's predecessor 
     */
    public void addDevice(Device newDev, int...preds){
        ArrayList adds = new ArrayList();
        if (preds.length>0){
            for (int address : preds) {
                adds.add(address);
                
            }
        }
        newDev.setNeighbors(adds);
        network.add(newDev);
    }
    
    public void sendMessage(String message, int freq, Device sender, int receiverID){
        int neigh = sender.getNeighbors().size();
        
        System.out.println("currently on node " + sender.getDeviceID() + " postion of visiting is " + counter);
        counter++;
        for (int i=0;i<neigh;i++){
            int curAdd = (sender.getNeighbors().get(i));
            if (curAdd== receiverID){
                
                network.get(receiverID).txt=message;
                System.out.println("Checking message "+ network.get(receiverID).txt);
                return;
            }
                
            else {
                
                Device newDev = network.get(curAdd);
                if (newDev.getFrequencies().contains(freq))
                    System.out.println("The message has already arrived at node "+ newDev.getDeviceID() + ", Discard please");
                else {
                    newDev.getFrequencies().add(freq);
                    sendMessage(message,freq, newDev, receiverID);
                }
                    
            }
        }
            
    }
    
    /**
     *
     * @param current
     */
    
    
    //giving each device a network key depends on its predicessor
//    public void setNetKey (Device current){
//            current.setNetKey(generateKey (current));
//    }
    
    /**
     *
     * @param device
     * @return
     */
    public String generateKey (Device device){
       String key = "";
       
       return key;
   }
    
}
