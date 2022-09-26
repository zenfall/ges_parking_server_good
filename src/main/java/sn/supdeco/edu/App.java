package sn.supdeco.edu;

import sn.supdeco.edu.services.IParking;
import sn.supdeco.edu.services.ParkingImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        try {
            ParkingImpl gesParking = new ParkingImpl();
            IParking stub = (IParking) UnicastRemoteObject.exportObject(gesParking,0);
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost:2000/parking", stub);
            System.out.println("Server Started !");
        }catch (RemoteException | MalformedURLException e){
            // e.printStackTrace();
            System.out.println(String.format("error : %s",e.getMessage()));
        }
    }
}
