package com.fluxstudy.fluxstudy.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String description;
    @Builder.Default private boolean delivered = false;

    public boolean isDelivered(){
        return delivered;
    }

    public static Dish deliever(Dish dish){
        return Dish.builder()
                .description(dish.getDescription())
                .delivered(true)
                .build();
    }

    @Override
    public String toString(){
        return "Dish{"+//
        "description='"+description+'\''+//
        ", delivered="+delivered+//
        '}';
    }



}
