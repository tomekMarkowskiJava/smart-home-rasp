package com.markowski.raspberrytest.repository;

import com.markowski.raspberrytest.model.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
