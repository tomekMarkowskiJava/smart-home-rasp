package com.markowski.raspberrytest.service;

import com.google.gson.Gson;
import com.markowski.raspberrytest.mapper.StateMapper;
import com.markowski.raspberrytest.model.dto.StateDto;
import com.markowski.raspberrytest.model.entity.State;
import com.markowski.raspberrytest.model.enums.StateType;
import com.markowski.raspberrytest.repository.StateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.ZonedDateTime;

@Service
@Slf4j
public class StateServiceImpl implements StateService {

    StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public StateDto getState() {
        StateDto newState = new Gson().fromJson(getStateFromServer(), StateDto.class);
        newState = saveState(newState, StateType.REAL);
        log.info(newState.toString());
        return newState;
    }

    @Override
    public StateDto getTestState() {
        StateDto testState = StateDto.builder()
                .humidity(25.5)
                .temp(36.6)
                .date(ZonedDateTime.now())
                .type(StateType.TEST)
                .build();

        testState = saveState(testState, StateType.TEST);
        log.info(testState.toString());
        return testState;
    }

    private String getStateFromServer() {
        try {
            String[] command = getCommand();
            StringBuilder jsonState = new StringBuilder();
            Process process = new ProcessBuilder(command).start();
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonState.append(line);
            }
            if (jsonState.length() == 0) {
                throw new RuntimeException();
            }
            return jsonState.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private StateDto saveState(StateDto stateDto, StateType type) {
        State newState = StateMapper.mapDtoToEntity(stateDto, type);
        return StateMapper.mapEntityToDto(stateRepository.save(newState));
    }

    private String[] getCommand() {
        return new String[]{"python3",
                "/home/t.markowski/dev/repo/Adafruit_Python_DHT/examples/AdafruitDHT.py",
                "22",
                "4"};
    }
}
