package learn.java.rmi.server.impl;

import learn.java.rmi.service.Warehouse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vigo on 17/11/6.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private static final long serialVersionUID = 1L;
    private Map<String,Double> prices;

    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<String,Double>();
        prices.put("mate7",3700.00);
    }

    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null? 0 : price;
    }
}
