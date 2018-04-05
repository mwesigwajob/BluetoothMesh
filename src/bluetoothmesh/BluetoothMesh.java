/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothmesh;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author jobmwesigwa
 */
public class BluetoothMesh {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Network myNetwork = new Network();
        final int NUM_OF_DEVICES =26;
        Device[] devices = new Device[NUM_OF_DEVICES];
        String file="";
        int edges;
        Scanner in = new Scanner(System.in);
        
        
        
        do{
        System.out.println("Enter the number of edges (3,4 or 5): ");
        edges = in.nextInt(); 
        
        if (edges == 3){
            file = "Configmesh3.txt";
            PrintStream out = new PrintStream(new FileOutputStream("Mesh3Output.log", true));
            System.setOut(out);
        }
        else if (edges == 4){
            file = "Configmesh4.txt";
            PrintStream out = new PrintStream(new FileOutputStream("Mesh4Output.log", true));
            System.setOut(out);
        }
        else if (edges == 5){
            file = "Configmesh5.txt";
            PrintStream out = new PrintStream(new FileOutputStream("Mesh5Output.log", true));
            System.setOut(out);
        }
        else
            System.out.println("Invalid entry: enter 3,4 or 5: ");
        }while (edges<3 || edges>5);
        
        
        
        try (BufferedReader myString = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            String currentLine=null;
            int counter =0;
            int counter1 =-1;
            while ((currentLine = myString.readLine())!=null)
            {
                if (counter ==0){
                }
                else{    
                    String [] myNode = currentLine.split("\t");
                    devices[counter1] = new Device(Integer.parseInt(myNode[1]));
                    
                    if (Integer.parseInt(myNode[3])==1)
                        devices[counter1].setRelay(true);
                    
                    String [] nieg = myNode[2].split(",");
                    int [] neighs = new int[nieg.length];
                    
                    for (int i =0; i<nieg.length; i++)
                        neighs[i] = Integer.parseInt(nieg[i]);
                    devices[counter1].addNeighbours(neighs);
                    
                    myNetwork.addDevice(devices[counter1]);
                    
                }
                counter++;
                ++counter1;
            }
        }
            //catching any excemtions
        catch (Exception e){
              System.out.println("Error -Other Exception "+e.toString());
            }
        System.out.println();
        System.out.println("\n\n \t\t ********Flooding********\n\n");
        System.out.println();
        Flooding flooding = new Flooding(myNetwork);
        BTMessage message = new BTMessage(devices[0],devices[25],1,"Here we are");
        flooding.flood(message);
        
//        System.out.println();
//        System.out.println();
//        System.out.println("\n\n \t\t ********Managed Flooding********\n\n");
//        System.out.println();
//        BTMessage message1 = new BTMessage(devices[0],devices[25],2,"Here we are");
//        flooding.floodManaged(message1);
//        
//        System.out.println();
//        System.out.println();
//        System.out.println("\n\n \t\t ********OSPF********\n\n");
//        System.out.println();
//        BTMessage message2 = new BTMessage(devices[0],devices[25],3,"Here we are");
//        OSPF.sendMessage(message1);
        
    }
   
    
}
