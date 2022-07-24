package com.example.carpark.Controller;

import com.example.carpark.Entity.Car;
import com.example.carpark.Service.CarParkService;
import org.reactivestreams.Publisher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;
import javax.annotation.PostConstruct;

@Controller
public class CarParkController {

    private FluxSink<Car> carStream;
    private ConnectableFlux<Car> carPublisher;


    @PostConstruct
    public void init() {

        Flux<Car> publisher = Flux.create(emitter -> {
            carStream = emitter;
        });
        carPublisher = publisher.publish();
        carPublisher.connect();
    }

    @QueryMapping
    public List<Car> getParkedCars() {
        return CarParkService.getInstance().getParkedCars();
    }

    @MutationMapping
    public Car parkCar(@Argument String id, @Argument String vehicleNumber, @Argument String vehicleType) {
        Car car = new Car(id, vehicleNumber, vehicleType);
        carStream.next(car);
        return CarParkService.getInstance().parkCar(car);

    }

    @SubscriptionMapping
    public Publisher<Car> notifyCarPark() {
        return carPublisher;
    }
}
