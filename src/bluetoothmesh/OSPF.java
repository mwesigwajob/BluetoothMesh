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
    private Network myNet;
    private ArrayList<Integer> messagePath;
    
    /**
     * @param network the network of nodes to be traversed
     * @param message the message to be sent
     * 
     * gets the shortest path
     * Uses it to send the message 
     */
    public void sendMessage(Network network, BTMessage message){
        Device sender = message.getSender();
        Device destination = message.getReceiver();
        myNet = network;
        messagePath = findPath(myNet,sender,destination);
        if (!messagePath.contains(destination.getDeviceID()))
            messagePath.add(destination.getDeviceID());
        for (int i = 0; i < messagePath.size(); i++) {
            System.out.println("Message sent to " + messagePath.get(i));
            if (messagePath.get(i)==destination.getDeviceID()){
                destination.setTxt(message.getMessage());
                System.out.println();
                System.out.println("Message Successfully delivered to "+sender.getDeviceID());
                System.out.println("Message Path: "+messagePath.toString());
                System.out.println("Total Hop count: "+messagePath.size());
                System.out.println("Hop count: "+messagePath.size());
            }
        }
    }
    
    /**
     * @param network the network of nodes to be traversed
     * @param source the source node
     * @param dest the destination node
     * @return List of shortest path from source to destination
     * initiate the distance of the fist node and add it to the visited nodes
     * Pick a node from the unvisited list
     * Update the path of its neighbors and add them to the unvisited list
     * add the node to the visited list
     */
    private ArrayList findPath(Network network, Device source, Device dest){
        
        //Keeping track of the visted and unvisted devices in the network
        ArrayList<Device> visited = new ArrayList();
        ArrayList<Device> unvisted = new ArrayList();
        
        //setting the distance of the first device and addindg it to the unvisited 
        source.setDist(0);
        unvisted.add(source);
        
        //Iterating through the unvisted list
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
                       
                    //updating the distance to neighbour and adding it to unvisited list
                    if (!visited.contains(neighbour)) {
                        getMinDistance(neighbour, dist, curDev);
                        unvisted.add(neighbour);
                    }
                    else if (visited.contains(neighbour))
                        trackVisted++;
                    
                    //adding current node to shortest path
                    if (trackVisted==curDev.getNeighbors().size() && !curDev.getShortestPath().contains(curDev.getDeviceID()))
                        curDev.getShortestPath().add(curDev.getDeviceID());
                    
                }
            }
            visited.add(curDev);
        }
        
        return dest.getShortestPath();   
    }
    /**
     * @param neigh the next node
     * @param current the node being visited
     * @param dist distance to next node
     * 
     * Checks if the new distance will improve the distance to the next node,
     * if it does, then it updates the path to the next distance
     */
    private void getMinDistance(Device neigh, int dist, Device current){
        int prevDistance = current.getDist();
        if (prevDistance + dist < neigh.getDist()) {
            neigh.setDist(prevDistance + dist);
            ArrayList<Integer> shortestPath = (ArrayList)current.getShortestPath().clone();
            shortestPath.add(current.getDeviceID());
            neigh.setShortestPath(shortestPath);
        }
    }
    
}
