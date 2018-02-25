/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author jobmwesigwa
 */
public class Network {
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
        
        //for bfs search
        Queue<Integer> queue = new LinkedList();
        int senderId = sender.getDeviceID();
        
        //loop to run through the entire network 
        do {
            
            //neigbours of the current node and adding the frequency if the message to node
            int neigh = sender.getNeighbors().size();
            sender.getFrequencies().add(freq);
            
            //going through neighbours 
            for (int i=0;i<neigh;i++){
                int curAdd = (sender.getNeighbors().get(i));
                int senderID = sender.getDeviceID();
                
                //deliver message if destination is reached 
                if (curAdd== receiverID){
                    (network.get(curAdd)).setPath(senderID,(network.get(senderID).path));
                    network.get(receiverID).txt=message;
                    unicast("Message Delivered", network.get(receiverID).path, network.get(receiverID), senderId);
                    return;
                }
                
                //ignore node if it has already been visted 
                if ((network.get(curAdd)).getFrequencies().contains(freq) || queue.contains(curAdd))
                    System.out.println("The message has already arrived at node "+ (network.get(curAdd)).getDeviceID() + ", Discard please");
                
                //add current node to the visited nodes and to the path taken by the message
                else{
                        (network.get(curAdd)).setPath(senderID,(network.get(senderID).path));
                    queue.add(curAdd);
                }
                
            }
            //updating the sender 
            
            sender = network.get(queue.remove());
            System.out.println();
            System.out.println();
            System.out.println(queue.size());
        } while (!queue.isEmpty()); 
    }
    
    public boolean unicast(String msg, Stack<Integer> backPath, Device sender, int receiverId){
      while (!backPath.isEmpty()){
          if (receiverId == backPath.pop()){
              System.out.println("Message Successfully delivered to "+sender.getDeviceID());
              return true;
          }
      }
      System.out.println("Feedback from Receiver not received");
      return false;
    }
}
