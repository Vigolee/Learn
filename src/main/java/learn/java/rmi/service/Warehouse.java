package learn.java.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Vigo on 17/11/6.
 */
public interface Warehouse extends Remote {
    
    double getPrice(String description) throws RemoteException;
}
