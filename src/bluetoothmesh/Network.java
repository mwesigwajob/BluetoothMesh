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
    /**
     * Adds the new device to the network arraylist and adds its reference to 
     * devices connected to it
     * @param newDev the new device to be added
     */
    public boolean addDevice(Device newDev){
        return network.add(newDev);
    }
    
    public boolean deleteDevice(Device newDev){
        return network.remove(newDev);
    }
    
    public void makeRelay (ArrayList<Integer> relays, ArrayList<Device> network){
        for (int i = 0; i<network.size(); i++){
            if (relays.contains(network.get(i).getDeviceID()))
                network.get(i).setRelay(true);
            else
                network.get(i).setRelay(false);
        }
    }
}
