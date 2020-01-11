package learn.java.rmi.server;

import learn.java.rmi.server.impl.WarehouseImpl;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Vigo on 17/11/6.
 */
public class WarehouseServer
{
    public static void main(String[] args) throws RemoteException, NamingException, MalformedURLException, AlreadyBoundException, AlreadyBoundException {
        System.out.println("Constructing server implementation");
        WarehouseImpl centralWarehouse = new WarehouseImpl();

        System.out.println("Binding server implementation to registry");
        LocateRegistry.createRegistry(1199);
        Naming.bind("rmi://localhost:1199/central_warehoues", centralWarehouse);

        System.out.println("Waiting for invocations from clients ...");
    }
}