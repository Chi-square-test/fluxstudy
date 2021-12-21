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
    Flux<Dish> serveDishes(){
        return kitchenService.getDishes();
    }

}
