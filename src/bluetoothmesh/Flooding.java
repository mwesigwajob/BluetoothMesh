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
    private Network myNet;
    private int hopCount = 0;
    private int maxHopCount = 150;
    public Flooding (Network network){
        myNet = network;
    }
    
    /**
     * Loops through the network to find destination or else stops when the
     * maximum hope count is reached.
     * At each node, goes through all neighbors to send message
     * discards a message that has already been received 
     * adds the neighbors to queues of nodes to be checked out if it's a relay node
     * delivers the message if one of the neighbors is the destination 
     * removes the current node from the queue
     * @param message the message to be sent 
     */
    public void managedFlooding(BTMessage message){
        String text = message.getMessage();
        int freq = message.getMessageFrequency();
        Device sender =message.getSender();
        int receiverID = message.getReceiver().getDeviceID();
        refresh();
        //for bfs search
        Queue<Integer> queue = new LinkedList();
        int senderId = sender.getDeviceID();
        hopCount = 0;
        sender.getCache().add(freq);
        //loop to run through the entire network 
        do {
            sender.setVisited(true);
            //neigbours of the current node and adding the frequency if the message to node
            int neigh = sender.getNeighbors().size();
            System.out.println("Message is currently at "+ sender.getDeviceID());
            //going through neighbours 
            for (int i=0;i<neigh;i++){
                int curAdd = (sender.getNeighbors().get(i));
                int senderID = sender.getDeviceID();
                
                System.out.println("\nMessage sent to " + curAdd);
                //deliver message if destination is reached 
                if (curAdd== receiverID){
                    
                    (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    myNet.network.get(curAdd).path.push(curAdd);
                    myNet.network.get(receiverID).txt=text;
                    unicast("Message Delivered", myNet.network.get(receiverID).path, myNet.network.get(receiverID), senderId);
                    return;
                }
                
                    
                //ignore node if it has already been visted 
                if ((myNet.network.get(curAdd)).getCache().contains(freq))
                    System.out.println("The message has already arrived at node "+ (myNet.network.get(curAdd)).getDeviceID() + ", Discard please");
                
                //add current node to the visited nodes and to the path taken by the message
                if (!(myNet.network.get(curAdd).isVisited())){
                    (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    if (myNet.network.get(curAdd).isRelay())
                        queue.add(curAdd);
                }
                
               myNet.network.get(curAdd).getCache().add(freq); 
               hopCount++;
            }
            //updating the sender 
            
            sender = myNet.network.get(queue.remove());
            System.out.println();
            System.out.println();
        } while (!queue.isEmpty() && hopCount<maxHopCount); 
    }
    /**
     * Loops through the network to find destination or else stops when the
     * maximum hope count is reached.
     * At each node, goes through all neighbors to send message
     * discards a message that has already been received 
     * adds the neighbors to queues of nodes to be checked out
     * delivers the message if one of the neighbors is the destination 
     * removes the current node from the queue
     * @param message the message to be sent 
     */
    public void flood(BTMessage message){
        String text = message.getMessage();
        int freq = message.getMessageFrequency();
        Device sender =message.getSender();
        int receiverID = message.getReceiver().getDeviceID();
        //for bfs search
        refresh();
        Queue<Integer> queue = new LinkedList();
        int senderId = sender.getDeviceID();
        hopCount = 0;
        sender.getCache().add(freq);
        //loop to run through the entire network 
        do {
            sender.setVisited(true);
            //neigbours of the current node and adding the frequency if the message to node
            int neigh = sender.getNeighbors().size();
            System.out.println("Message is currently at "+ sender.getDeviceID());
            //going through neighbours 
            for (int i=0;i<neigh;i++){
                int curAdd = (sender.getNeighbors().get(i));
                int senderID = sender.getDeviceID();
                
                System.out.println("\nMessage sent to " + curAdd);
                //deliver message if destination is reached 
                if (curAdd== receiverID){
                    
                    (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    myNet.network.get(curAdd).path.push(curAdd);
                    myNet.network.get(receiverID).txt=text;
                    unicast("Message Delivered", myNet.network.get(receiverID).path, myNet.network.get(receiverID), senderId);
                    return;
                }
                
                    
                //ignore node if it has already been visted 
                if ((myNet.network.get(curAdd)).getCache().contains(freq))
                    System.out.println("The message has already arrived at node "+ (myNet.network.get(curAdd)).getDeviceID() + ", Discard please");
                
                //add current node to the visited nodes and to the path taken by the message
                if (!(myNet.network.get(curAdd).isVisited())){
                    (myNet.network.get(curAdd)).setPath(senderID,(myNet.network.get(senderID).path));
                    queue.add(curAdd);
                }
                
               myNet.network.get(curAdd).getCache().add(freq); 
               hopCount++;
            }
            //updating the sender 
            
            sender = myNet.network.get(queue.remove());
            System.out.println();
            System.out.println();
        } while (!queue.isEmpty() && hopCount<maxHopCount); 
    }
    
    /**
     * @param msg the message to be delivered 
     * @param backPath the path of nodes back to source
     * @param sender the source node
     * @param receiverId the address of the destination node
     * @return Boolean the confirmation whether the message is delivered.
     * Sends the acknowledgement  message back to source using the path it took
     * on delivery
    */
    private boolean unicast(String msg, Stack<Integer> backPath, Device sender, int receiverId){
        int size =backPath.size();
        System.out.println();
        System.out.println();
        System.out.println("Message Successfully delivered to "+sender.getDeviceID());
        System.out.println("The message path is "+ backPath.toString());
        while (!backPath.isEmpty()){
          if (receiverId == backPath.pop()){
              System.out.println("The total hope count is: "+hopCount);
              System.out.println("The path length is: " + size);
              return true;
          }
      }
      System.out.println("Feedback from Receiver not received");
      return false;
    }
    
    /*
    *Refreshes the nodes from being visted after runing the algorithm
    */
    private void refresh(){
        for (int i =0; i<myNet.network.size();i++)
            if (myNet.network.get(i).isVisited())
                myNet.network.get(i).setVisited(false);
    }
}
