/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author jobmwesigwa
 */
public class Flooding {
    Network myNet;
    
    public Flooding (Network network){
        myNet = network;
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
            System.out.println("Message is currently at "+ sender.getDeviceID());
            //going through neighbours 
            for (int i=0;i<neigh;i++){
                int curAdd = (sender.getNeighbors().get(i));
                int senderID = sender.getDeviceID();
                System.out.println("\nMessage sent to " + curAdd);
                //deliver message if destination is reached 
                if (curAdd== receiverID){
                    (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    myNet.network.get(receiverID).txt=message;
                    unicast("Message Delivered", myNet.network.get(receiverID).path, myNet.network.get(receiverID), senderId);
                    return;
                }
                
                //ignore node if it has already been visted 
                if ((myNet.network.get(curAdd)).getFrequencies().contains(freq) || queue.contains(curAdd))
                    System.out.println("The message has already arrived at node "+ (myNet.network.get(curAdd)).getDeviceID() + ", Discard please");
                
                //add current node to the visited nodes and to the path taken by the message
                else{
                        (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    queue.add(curAdd);
                }
                
            }
            //updating the sender 
            
            sender = myNet.network.get(queue.remove());
            System.out.println();
            System.out.println();
        } while (!queue.isEmpty()); 
    }
    
    public boolean unicast(String msg, Stack<Integer> backPath, Device sender, int receiverId){
        System.out.println("The message path is "+ backPath.toString());
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
