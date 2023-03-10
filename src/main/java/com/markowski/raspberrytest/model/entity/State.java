package com.markowski.raspberrytest.model.entity;

import com.markowski.raspberrytest.model.enums.StateType;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table
@Setter
@Getter
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column
    private Double temp;

    @Column
    private Double humidity;

    @Column
    private ZonedDateTime date;

    @Column
    private StateType type;
}
