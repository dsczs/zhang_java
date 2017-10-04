package com.zhang;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteHelloWord extends Remote {
    String sayHello() throws RemoteException;
}
