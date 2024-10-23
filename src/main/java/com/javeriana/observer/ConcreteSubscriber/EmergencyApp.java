package com.javeriana.observer.ConcreteSubscriber;

import com.javeriana.observer.Subscriber.InterfaceSubscriber;

public class EmergencyApp implements InterfaceSubscriber {
    private String appName;

    public EmergencyApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void  update(String weatherUpdate) {
        System.out.println(appName + " activó notificaciones de emergencia debido al clima: " + weatherUpdate);
    }
}
