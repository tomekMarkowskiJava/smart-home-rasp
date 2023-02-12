package com.markowski.raspberrytest.mapper;

import com.markowski.raspberrytest.model.dto.StateDto;
import com.markowski.raspberrytest.model.entity.State;
import com.markowski.raspberrytest.model.enums.StateType;

import java.time.ZonedDateTime;

public class StateMapper {

    public static StateDto mapEntityToDto(State state){
        return StateDto.builder()
                .id(state.getId())
                .humidity(state.getHumidity())
                .type(state.getType())
                .temp(state.getTemp())
                .date(state.getDate())
                .build();
    }

    public static State mapDtoToEntity(StateDto stateDto, StateType type) {
        State state = new State();
        state.setId(stateDto.getId());
        state.setTemp(stateDto.getTemp());
        state.setHumidity(stateDto.getHumidity());
        state.setType(type);
        state.setDate(ZonedDateTime.now());
        return state;
    }
}
