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
public class OSPF {
    Network myNet;
    ArrayList messagePath = new ArrayList<Device>();
    
    public void sendMessage(Network network, Device sender, Device destination){
        myNet = network;
        messagePath = findPath(myNet,sender,destination);
    }
    
    public ArrayList findPath(Network network, Device source, Device destination){
        source.setDist(0);

        ArrayList<Device> visited = new ArrayList<Device>();
        ArrayList<Device> unvisted = new ArrayList<Device>();

        unvisted.add(source);

        while (!unvisted.isEmpty()) {
            Device curDev = getLowestDistanceNode(unvisted);
            unvisted.remove(curDev);
            for(int i=0; i<curDev.getNeighbors().size();i++) {
                Device neighbour = network.network.get(curDev.getDeviceID());
                int dist = 1;
                if (!visited.contains(neighbour)) {
                    calculateMinimumDistance(neighbour, dist, curDev);
                    unvisted.add(neighbour);
                }
            }
            visited.add(curDev);
        }
        return destination.getShortestPath();   
    }
    
}
