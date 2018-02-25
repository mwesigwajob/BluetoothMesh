/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;
import java.util.Stack;

/**
 *
 * @author jobmwesigwa
 */
public class BluetoothMesh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Network myNetwork = new Network();
        
        Device nokia = new Device(0);
        Device lamp = new Device(1);
        Device ac = new Device(2);
        Device samsung = new Device(3);
        Device iphone = new Device(4);
        Device macBook = new Device(5);
        Device pc = new Device(6);
        
        nokia.addNeighbours(1,2,3);
        lamp.addNeighbours(0,4);
        ac.addNeighbours(0,4,5,6);
        samsung.addNeighbours(0,5);
        iphone.addNeighbours(1,2,6);
        macBook.addNeighbours(2,3,6);
        pc.addNeighbours(2,4,5);
        
        myNetwork.addDevice(nokia);
        myNetwork.addDevice(lamp);
        myNetwork.addDevice(ac);
        myNetwork.addDevice(samsung);
        myNetwork.addDevice(iphone);
        myNetwork.addDevice(macBook);
        myNetwork.addDevice(pc);
        
//        Flooding flooding = new Flooding(myNetwork);
//        flooding.sendMessage("Here we are", 2, iphone, 3);
        
        OSPF ospf = new OSPF();
        
        ospf.sendMessage(myNetwork, iphone, samsung);
        
        System.out.println("The message at samsung is " + samsung.txt);
        
    }
    
}
