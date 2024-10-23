package com.javeriana.observer.ConcreteSubscriber;

import com.javeriana.observer.Subscriber.InterfaceSubscriber;

public class NewsApp implements InterfaceSubscriber {
    private String appName;

    public NewsApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String weatherUpdate) {
        System.out.println(appName + " recibió la actualización del clima: " + weatherUpdate);
    }
}
