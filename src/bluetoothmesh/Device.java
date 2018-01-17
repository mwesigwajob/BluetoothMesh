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
public class Device {
    private boolean relay = false;
    private boolean proxy = false;
    private boolean friend = false;
    private String state = "";
    private int deviceID = 0;
    private int netKey = 0, messageFrequency = 0;
    private String address ="";
    private boolean provisioner = false;
    private ArrayList<Integer> neighbors, frequencies = new ArrayList<Integer>();
    public String txt = "";
    
    //Constructor for the prvisioner

    /**
     *
     * @param netky
     * @param prov
     */
    public Device (int netky,boolean prov)
    {
        netKey = netky;
        provisioner = prov;
    }
    
    //constructor for other devices 

    /**
     *
     * @param devKy
     */
    public Device (int devKy)
    {
        deviceID = devKy;
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
    public boolean isProxy() {
        return proxy;
    }

    /**
     *
     * @param proxy
     */
    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }

    /**
     *
     * @return
     */
    public boolean isFriend() {
        return friend;
    }

    /**
     *
     * @param friend
     */
    public void setFriend(boolean friend) {
        this.friend = friend;
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
    public int getNetKey() {
        return netKey;
    }

    /**
     *
     * @param netKey
     */
    public void setNetKey(int netKey) {
        this.netKey = netKey;
    }

    /**
     *
     * @return
     */
    public boolean isProvisioner() {
        return provisioner;
    }

    /**
     *
     * @param provisioner
     */
    public void setProvisioner(boolean provisioner) {
        this.provisioner = provisioner;
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
     *
     * @return
     */
    public Boolean getProxy() {
        return proxy;
    }

    /**
     *
     * @param proxy
     */
    public void setProxy(Boolean proxy) {
        this.proxy = proxy;
    }

    /**
     *
     * @return
     */
    public Boolean getFriend() {
        return friend;
    }

    /**
     *
     * @param friend
     */
    public void setFriend(Boolean friend) {
        this.friend = friend;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
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
    
    
}
