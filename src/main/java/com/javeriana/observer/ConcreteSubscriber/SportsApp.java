package com.javeriana.observer.ConcreteSubscriber;

import com.javeriana.observer.Subscriber.InterfaceSubscriber;

public class SportsApp implements InterfaceSubscriber {
    private String appName;

    public SportsApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String weatherUpdate) {
        System.out.println(appName + " actualizó sus eventos deportivos según el clima: " + weatherUpdate);
    }
}