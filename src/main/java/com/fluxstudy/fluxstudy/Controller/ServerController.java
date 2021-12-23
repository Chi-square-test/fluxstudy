package com.fluxstudy.fluxstudy.Controller;

import com.fluxstudy.fluxstudy.DTO.Dish;
import com.fluxstudy.fluxstudy.Service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerController {

    @Autowired
    private KitchenService kitchenService;

    @GetMapping(value = "/server",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> serveDishes(){
        return kitchenService.getDishes();
    }

    @GetMapping(value = "/servered-dishes",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> deliverDishes(){
        return kitchenService.getDishes() //기존 객체가 아닌 새로운 객체를 생성하여 내용 변경
                .map(Dish::deliever); //람다식 어질어질
    }

}
