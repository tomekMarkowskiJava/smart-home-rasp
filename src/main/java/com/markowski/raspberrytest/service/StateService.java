package com.markowski.raspberrytest.service;

import com.markowski.raspberrytest.model.dto.StateDto;

public interface StateService {
    StateDto getState();

    StateDto getTestState();
}
