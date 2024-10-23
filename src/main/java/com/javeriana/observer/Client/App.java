package com.javeriana.observer.Client;

import com.javeriana.observer.ConcreteSubscriber.EmergencyApp;
import com.javeriana.observer.ConcreteSubscriber.NewsApp;
import com.javeriana.observer.ConcreteSubscriber.SportsApp;
import com.javeriana.observer.Publisher.WeatherStation;
import com.javeriana.observer.Subscriber.InterfaceSubscriber;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Crear estación de clima (WeatherStation)
        WeatherStation weatherStation = new WeatherStation();

        // Crear las aplicaciones suscriptoras
        InterfaceSubscriber newsApp = new NewsApp("App de Noticias");
        InterfaceSubscriber sportsApp = new SportsApp("App de Deportes");
        InterfaceSubscriber emergencyApp = new EmergencyApp("App de Emergencias");

        // AL NO HABER FILTROS, TODAS LAS APLICACIONES RECIBEN LA INFORMACIÓN DE CLIMA

        // Suscribir las aplicaciones a la estación de clima
        weatherStation.subscribe(newsApp);
        weatherStation.subscribe(sportsApp);
        weatherStation.subscribe(emergencyApp);

        // Actualización del clima y notificación a las apps
        weatherStation.setWeatherState("Tormenta severa");

        // Desuscribir una app
        weatherStation.unsubscribe(sportsApp);

        // Otra actualización del clima
        weatherStation.setWeatherState("Clima despejado");

        //  AL ACTIVAR LOS FILTROS, SÓLO RE RECIBE INFORMACIÓN DE CLIMA EQUIVALENTE AL FILTRO (De los temas a los que esté suscrito el cliente)

        System.out.println("Filtrando por tormenta");

        // Agregar un filtro
        // Activa un filtro que envía información sólo cuando el clima es "Tormenta severa"
        weatherStation.addFilter("Tormenta severa");

        // Actualización del clima y notificación a las apps
        // Si se comenta no llega ninguna noti
        weatherStation.setWeatherState("Tormenta severa");

        // No llega ninguna noti porque sólo hay filtro para ver información de clima despejado
        weatherStation.setWeatherState("Clima despejado");

        // Para eliminar el sistema de filtros, el objeto WeatherStation debe tener un método removeFilter


    }
}
