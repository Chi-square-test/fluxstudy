package com.fluxstudy.fluxstudy.Service;

import com.fluxstudy.fluxstudy.DTO.Dish;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {
    public Flux<Dish> getDishes(){
        return Flux.<Dish> generate(sink -> sink.next(randomDish()))//
                .delayElements(Duration.ofMillis(250));
    }

    private Dish randomDish(){
        return menu.get(picker.nextInt(menu.size()));
    }

    private List<Dish> menu = Arrays.asList(
            new Dish("Sesame chicken",false),
            new Dish("불닭볶음면",false),
            new Dish("알리오올리오",false)
    );

    private Random picker = new Random();
}
