package com.zhang;

import java.rmi.RemoteException;

public class RemoteHelloWordImpl implements RemoteHelloWord {
    public String sayHello() throws RemoteException {
        return "Hello World";
    }
}
