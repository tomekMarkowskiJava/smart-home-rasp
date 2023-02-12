package com.markowski.raspberrytest.model.dto;

import com.markowski.raspberrytest.model.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Builder
public class StateDto {
    private Long id;
    private Double temp;
    private Double humidity;
    private ZonedDateTime date;
    private StateType type;

    @Override
    public String toString() {
        return "StateDto{" +
                "id=" + id +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
