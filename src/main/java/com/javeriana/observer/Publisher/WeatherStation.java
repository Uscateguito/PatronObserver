package com.javeriana.observer.Publisher;

import java.util.ArrayList;
import java.util.List;

import com.javeriana.observer.Subscriber.InterfaceSubscriber;

// Publisher class
public class WeatherStation {
    private List<InterfaceSubscriber> subscribers = new ArrayList<>();
    private String weatherState;
    private List<String> filters = new ArrayList<>();

    // Suscribir a un observador
    public void subscribe(InterfaceSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Desuscribir a un observador
    public void unsubscribe(InterfaceSubscriber subscriber) {
        subscribers.remove(subscriber);
    }


    // Notificar a todos los suscriptores
    public void notifySubscribersWithFilter() {
        for (InterfaceSubscriber subscriber : subscribers) {
            if (filters.isEmpty()) {
                subscriber.update(weatherState);
            }
            else {
                checkFilter(subscriber);
            }
        }
    }

    private void checkFilter(InterfaceSubscriber subscriber) {
        for (String filter : filters) {
            if (weatherState.equals(filter)) {
                subscriber.update(weatherState);
            }
        }
    }

    // El usuario indica un filtro, ese filtro es un nuevo atributo de la clase WeatherStation, cada vez que se notifiquen a los subscribtores,
    // se debe verificar si el filtro coincide con el estado del clima, si coincide se notifica al suscriptor, si no coincide no se notifica.

    public void addFilter(String filter) {
        this.filters.add(filter);
    }

    public void removeFilter(String filter) {
        this.filters.remove(filter);
    }

    // Cambiar el estado del clima y notificar a los suscriptores
    public void setWeatherState(String newWeatherState) {
        this.weatherState = newWeatherState;
        // notifySubscribers();
        notifySubscribersWithFilter();
    }
}
