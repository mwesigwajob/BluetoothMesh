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
    ArrayList<Device> messagePath;
    
    public void sendMessage(Network network, Device sender, Device destination){
        myNet = network;
        messagePath = findPath(myNet,sender,destination);
        System.out.println("\t\t********OSPF********\n");
        for (int i = 0; i < messagePath.size(); i++) {
            System.out.println("The message is currently at " + messagePath.get(i).getDeviceID()+ " is " +destination.getTxt());
            if (messagePath.get(i).equals(destination)){
                destination.setTxt("OSPF we have made it");
                
            }
        }
    }
    
    private ArrayList findPath(Network network, Device source, Device dest){
        
        //Keeping track of the visted and unvisted devices in the network
        ArrayList<Device> visited = new ArrayList();
        ArrayList<Device> unvisted = new ArrayList();
        
        //setting the distance of the first device and addind it to the unvisited 
        source.setDist(0);
        unvisted.add(source);
        
        //Iterating through the unnisted list
        while (!unvisted.isEmpty()) {
            
            Device curDev = null;
            int minDist = Integer.MAX_VALUE;
            
            for (int i=0; i<unvisted.size();i++) {
                int devDist = unvisted.get(i).getDist();
                if (devDist < minDist) {
                    minDist = devDist;
                    curDev = unvisted.get(i);
                }
            }
            
            unvisted.remove(curDev);
            
            if (curDev.getNeighbors()!=null){
                int trackVisted =0;
                for(int i=0; i<curDev.getNeighbors().size();i++) {
                    //considering the weight of each node to be 1
                    int dist = 1;
                    Device neighbour = network.network.get(curDev.getNeighbors().get(i));

                    if (!visited.contains(neighbour)) {
                        getMinDistance(neighbour, dist, curDev);
                        unvisted.add(neighbour);
                    }
                    else if (visited.contains(neighbour))
                        trackVisted++;
                    if (trackVisted==curDev.getNeighbors().size() && !curDev.getShortestPath().contains(curDev))
                        curDev.getShortestPath().add(curDev);
                    
                }
            }
            visited.add(curDev);
        }
        
        return dest.getShortestPath();   
    }
    
    private void getMinDistance(Device neigh, int dist, Device current){
        int prevDistance = current.getDist();
        if (prevDistance + dist < neigh.getDist()) {
            neigh.setDist(prevDistance + dist);
            ArrayList<Device> shortestPath = (ArrayList)current.getShortestPath().clone();
            shortestPath.add(current);
            neigh.setShortestPath(shortestPath);
        }
    }
    
}
