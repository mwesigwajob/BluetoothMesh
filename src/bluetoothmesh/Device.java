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
    private ArrayList<Integer> neighbors, frequencies = new ArrayList<Integer>();
    public String txt = "";
    public Stack<Integer> path = new Stack<Integer>();
    
    //instances required for OSPF
    private int dist = Integer.MAX_VALUE;
    public ArrayList<Device> shortestPath = new ArrayList<Device>();
    /**
     *
     * @param devKy
     */
    public Device (int devKy)
    {
        deviceID = devKy;
    }
    
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
     *
     * @param prevPath
     */
    public void setPath(int sender, Stack<Integer> prevPath)
    { 
        if (prevPath.isEmpty() || prevPath.peek()!=sender)
            prevPath.push(sender);
        System.out.println("thi is the id "+ prevPath.peek());
        path = (Stack)prevPath.clone();
    }

    /**
     *
     * @return
     */
    public Boolean getRelay() {
        return relay;
    }

    /**
     *
     * @return
     */
    public boolean isRelay() {
        return relay;
    }

    /**
     *
     * @param relay
     */
    public void setRelay(boolean relay) {
        this.relay = relay;
    }
    /**
     *
     * @return
     */
    public int getDeviceID() {
        return deviceID;
    }

    /**
     *
     * @param deviceID
     */
    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }

    /**
     *
     * @param neighbors
     */
    public void setNeighbors(ArrayList<Integer> neighbors) {
        this.neighbors = neighbors;
    }
    
    /**
     *
     * @param relay
     */
    public void setRelay(Boolean relay) {
        this.relay = relay;
    }

    
    /**
     * @return the frequencies
     */
    public ArrayList<Integer> getFrequencies() {
        return frequencies;
    }

    /**
     * @param frequencies the frequencies to set
     */
    public void setFrequencies(ArrayList<Integer> frequencies) {
        this.frequencies = frequencies;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Stack<Integer> getPath() {
        return path;
    }

    public void setPath(Stack<Integer> path) {
        this.path = path;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public ArrayList<Device> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(ArrayList<Device> shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    
}
