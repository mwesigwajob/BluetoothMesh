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
public class Network {
    public ArrayList<Device> network = new ArrayList();
    int counter =0;
    
    /**
     * Adds the new device to the network arraylist and adds its reference to 
     * devices connected to it
     * @param newDev the new device to be added
     */
    public void addDevice(Device newDev){
        network.add(newDev);
    }
    
}
