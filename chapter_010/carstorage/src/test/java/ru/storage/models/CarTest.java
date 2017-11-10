package ru.storage.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nikolay on 10/11/17.
 */
public class CarTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void destroy() {
        SESSION_FACTORY.close();
    }

    @Before
    public void addCars() {
        Session session =SESSION_FACTORY.openSession();
        session.beginTransaction();

        CarBody body = new CarBody("body 1");
        Engine engine = new Engine("engine 1");
        Transmission transmission = new Transmission("transmission 1");
        Wheel wheel1 = new Wheel("wheel 1");
        Wheel wheel2 = new Wheel("wheel 2");
        Wheel wheel3 = new Wheel("wheel 3");
        Wheel wheel4 = new Wheel("wheel 4");

        session.save(body);
        session.save(engine);
        session.save(transmission);
        session.save(wheel1);
        session.save(wheel2);
        session.save(wheel3);
        session.save(wheel4);

        Car car = new Car();
        car.setBody(body);
        car.setEngine(engine);
        car.setTransmission(transmission);
        car.setWheels(Arrays.asList(wheel1, wheel2, wheel3, wheel4));

        session.save(car);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void carTest() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Car> cars = session.createQuery("from Car").list();

        System.out.println(cars);

        session.close();
    }
}
