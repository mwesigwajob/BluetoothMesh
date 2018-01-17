/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;

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
        
        myNetwork.addDevice(nokia,1,2,3);
        myNetwork.addDevice(lamp, 0,4);
        myNetwork.addDevice(ac,0,4,5);
        myNetwork.addDevice(samsung,0,5);
        myNetwork.addDevice(iphone, 1,2,6);
        myNetwork.addDevice(macBook, 2,3,6);
        myNetwork.addDevice(pc, 2,4,5);
        
        myNetwork.sendMessage("Here we are", 2, nokia, 6);
        
        System.out.println("The message at Nokia is " + nokia.txt);
    }
    
}
