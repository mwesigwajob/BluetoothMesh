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
    static Network myNetwork = new Network();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        twentyOneNodes();
//        Flooding flooding = new Flooding(myNetwork);
//        flooding.sendMessage("Here we are", 2, iphone, 3);
        
        
        
    }
    
    public static void sevenNodes(){
        Device A = new Device(0);
        Device B = new Device(1);
        Device C = new Device(2);
        Device D = new Device(3);
        Device E = new Device(4);
        Device F = new Device(5);
        Device G = new Device(6);
        
        A.addNeighbours(1,2,3);
        B.addNeighbours(0,4);
        C.addNeighbours(0,4,5,6);
        D.addNeighbours(0,5);
        E.addNeighbours(1,2,6);
        F.addNeighbours(2,3,6);
        G.addNeighbours(2,4,5);
        
        myNetwork.addDevice(A);
        myNetwork.addDevice(B);
        myNetwork.addDevice(C);
        myNetwork.addDevice(D);
        myNetwork.addDevice(E);
        myNetwork.addDevice(F);
        myNetwork.addDevice(G);
        
        OSPF ospf = new OSPF();
        
        ospf.sendMessage(myNetwork, E, D);
        
        System.out.println("The message at samsung is " + D.txt);
    }
    
    public static void fourteenNodes(){
        Device A = new Device(0);
        Device B = new Device(1);
        Device C = new Device(2);
        Device D = new Device(3);
        Device E = new Device(4);
        Device F = new Device(5);
        Device G = new Device(6);
        Device H = new Device(7);
        Device I = new Device(8);
        Device J = new Device(9);
        Device K = new Device(10);
        Device L = new Device(11);
        Device M = new Device(12);
        Device N = new Device(13);
        
        A.addNeighbours(1,2);
        B.addNeighbours(0,3,4);
        C.addNeighbours(0,5,6);
        D.addNeighbours(1,7);
        E.addNeighbours(1,7);
        F.addNeighbours(2,6,7,8,9);
        G.addNeighbours(2,5,10);
        H.addNeighbours(3,4,5,8,11);
        I.addNeighbours(5,7,12,13);
        J.addNeighbours(5,10,13);
        K.addNeighbours(5,6);
        L.addNeighbours(7,12);
        M.addNeighbours(11,8);
        N.addNeighbours(8,9);
        
        myNetwork.addDevice(A);
        myNetwork.addDevice(B);
        myNetwork.addDevice(C);
        myNetwork.addDevice(D);
        myNetwork.addDevice(E);
        myNetwork.addDevice(F);
        myNetwork.addDevice(G);
        myNetwork.addDevice(H);
        myNetwork.addDevice(I);
        myNetwork.addDevice(J);
        myNetwork.addDevice(K);
        myNetwork.addDevice(L);
        myNetwork.addDevice(M);
        myNetwork.addDevice(N);
        
        OSPF ospf = new OSPF();
        
        ospf.sendMessage(myNetwork, A, M);
        
        System.out.println("The message at samsung is " + M.txt);
    }
    
    public static void twentyOneNodes(){
        Device A = new Device(0);
        Device B = new Device(1);
        Device C = new Device(2);
        Device D = new Device(3);
        Device E = new Device(4);
        Device F = new Device(5);
        Device G = new Device(6);
        Device H = new Device(7);
        Device I = new Device(8);
        Device J = new Device(9);
        Device K = new Device(10);
        Device L = new Device(11);
        Device M = new Device(12);
        Device N = new Device(13);
        Device O = new Device(14);
        Device P = new Device(15);
        Device Q = new Device(16);
        Device R = new Device(17);
        Device S = new Device(18);
        Device T = new Device(19);
        Device U = new Device(20);
        
        A.addNeighbours(1,2,3);
        B.addNeighbours(0,4);
        C.addNeighbours(0,3,5);
        D.addNeighbours(0,2,6,7);
        E.addNeighbours(1,5,8);
        F.addNeighbours(2,4,6,8);
        G.addNeighbours(3,5,7,9);
        H.addNeighbours(3,6,10);
        I.addNeighbours(4,5,9,11,12);
        J.addNeighbours(6,8,13,14);
        K.addNeighbours(7,15);
        L.addNeighbours(8,12);
        M.addNeighbours(8,11,16,17);
        N.addNeighbours(9,17,18);
        O.addNeighbours(9,19);
        P.addNeighbours(10,14,19);
        Q.addNeighbours(12,17);
        R.addNeighbours(12,13,16,20);
        S.addNeighbours(13,19,20);
        T.addNeighbours(15,18);
        U.addNeighbours(17,18);
        
        myNetwork.addDevice(A);
        myNetwork.addDevice(B);
        myNetwork.addDevice(C);
        myNetwork.addDevice(D);
        myNetwork.addDevice(E);
        myNetwork.addDevice(F);
        myNetwork.addDevice(G);
        myNetwork.addDevice(H);
        myNetwork.addDevice(I);
        myNetwork.addDevice(J);
        myNetwork.addDevice(K);
        myNetwork.addDevice(L);
        myNetwork.addDevice(M);
        myNetwork.addDevice(N);
        myNetwork.addDevice(O);
        myNetwork.addDevice(P);
        myNetwork.addDevice(Q);
        myNetwork.addDevice(R);
        myNetwork.addDevice(S);
        myNetwork.addDevice(T);
        myNetwork.addDevice(U);
        
        OSPF ospf = new OSPF();
        
        ospf.sendMessage(myNetwork, A, U);
        
        System.out.println("The message at U is " + U.txt);
        
        System.out.println("\n\n \t\t ********Flooding********\n\n");
        Flooding flooding = new Flooding(myNetwork);
        flooding.sendMessage("Here we are", 2, A, 20);
        System.out.println("The message at U is " + U.txt);
    }
}
