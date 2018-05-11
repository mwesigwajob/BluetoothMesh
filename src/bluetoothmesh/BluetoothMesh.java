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
        
        
        /**
         * user selects the number of edges and the desired configuration file
         * and log files set for both the input and output
         */
        do{
        System.out.println("Enter the number of edges (3,4 or 5): ");
        edges = in.nextInt(); 
        
        if (edges == 3){
            file = "config/Configmesh3.txt";
            PrintStream out = new PrintStream(new FileOutputStream("logs/Mesh3Output.log"));
            System.setOut(out);
        }
        else if (edges == 4){
            file = "config/Configmesh4.txt";
            PrintStream out = new PrintStream(new FileOutputStream("logs/Mesh4Output.log"));
            System.setOut(out);
        }
        else if (edges == 5){
            file = "config/Configmesh5.txt";
            PrintStream out = new PrintStream(new FileOutputStream("logs/Mesh5Output.log"));
            System.setOut(out);
        }
        else
            System.out.println("Invalid entry: enter 3,4 or 5: ");
        }while (edges<3 || edges>5);
        
        
        /**
         * set the instances of the each node and run all the 3 algorithms 
         */
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
        
        //flooding
        System.out.println();
        System.out.println("\n\n \t\t ********Flooding********\n\n");
        System.out.println();
        Flooding flooding = new Flooding(myNetwork);
        BTMessage message = new BTMessage(devices[0],devices[25],1,"message");
        flooding.flood(message);
        
        //Managed flooding
        System.out.println();
        System.out.println();
        System.out.println("\n\n \t\t ********Managed Flooding********\n\n");
        System.out.println();
        message.setMessageFrequency(2); 
        flooding.managedFlooding(message);
        
        //OSPF
        System.out.println();
        System.out.println();
        System.out.println("\n\n \t\t ********OSPF********\n\n");
        System.out.println();
        OSPF ospf = new OSPF();
        ospf.sendMessage(myNetwork,message);
    }
}
