/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author jobmwesigwa
 */
public class Device {

    
    private boolean relay = false;
    private int deviceID = 0;
    private ArrayList<Integer> neighbors, cache = new ArrayList<Integer>();
    public String txt = "";
    private Boolean visited = false;
    public Stack<Integer> path = new Stack<Integer>();
    
    //instances required for OSPF
    private int dist = Integer.MAX_VALUE;
    public ArrayList<Integer> shortestPath = new ArrayList<Integer>();
    /**
     *
     * @param devKy the device address/key
     */
    public Device (int devKy)
    {
        deviceID = devKy;
    }
    
    /**
     * Adds neighbors to the device neighbors list
     * @param preds an array of neighbors 
     */
    public void addNeighbours(int...preds){
        ArrayList adds = new ArrayList();
        if (preds.length>0){
            for (int address : preds) {
                adds.add(address);
            }
        }
        setNeighbors(adds);
    }
    
    /**
     * sets the path of the current node
     * @param sender the address of the sending node
     * @param prevPath the original path to the current node
     */
    public void setPath(int sender, Stack<Integer> prevPath)
    { 
        if (prevPath.isEmpty() || prevPath.peek()!=sender)
            prevPath.push(sender);
        path = (Stack)prevPath.clone();
    }
    /**
     *
     * @return Boolean whether the node is relay or not 
     */
    public boolean isRelay() {
        return relay;
    }
    /**
     *
     * @return the address of the device
     */
    public int getDeviceID() {
        return deviceID;
    }
    /**
     *
     * @param deviceID the address if the node
     */
    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }
    /**
     *
     * @return the list of neighbors 
     */
    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }
    /**
     *
     * @param neighbors the list of neighbors 
     */
    public void setNeighbors(ArrayList<Integer> neighbors) {
        this.neighbors = neighbors;
    }    
    /**
     *
     * @param relay a boolean state of the node if it is relay or not 
     */
    public void setRelay(Boolean relay) {
        this.relay = relay;
    }
    /**
     * @return the cache the list of frequencies that have been received
     */
    public ArrayList<Integer> getCache() {
        return cache;
    }
    /**
     * @param cache the cache to set
     */
    public void setCache(ArrayList<Integer> cache) {
        this.cache = cache;
    }
    /**
     * 
     * @return text the message sent
     */
    public String getTxt() {
        return txt;
    }
    /**
     * 
     * @param txt the message sent 
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }
    /**
     * 
     * @return path to the node
     */
    public Stack<Integer> getPath() {
        return path;
    }
    /**
     * 
     * @param path the path to the node
     */
    public void setPath(Stack<Integer> path) {
        this.path = path;
    }
    /**
     * 
     * @return distance to the node
     */
    public int getDist() {
        return dist;
    }
    /**
     * 
     * @param dist distance to the node
     */
    public void setDist(int dist) {
        this.dist = dist;
    }
    /**
     * 
     * @return the shortest path to the node
     */
    public ArrayList<Integer> getShortestPath() {
        return shortestPath;
    }
    /**
     * 
     * @param shortestPath the shortest path to the node
     */
    public void setShortestPath(ArrayList<Integer> shortestPath) {
        this.shortestPath = shortestPath;
    }
    /**
     * sets the node to a new state of visited
     * @param visited the visited to set
     */
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
    /**
     * 
     * @return the state of the node whether visited
     */
    public boolean isVisited() {
        return visited;
    }
}
