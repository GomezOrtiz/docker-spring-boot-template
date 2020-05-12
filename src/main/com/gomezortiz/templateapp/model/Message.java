package com.gomezortiz.templateapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "messages")
public class Message {

    @Id
    private final UUID id;

    @Column(name = "code", unique = true, nullable = false)
    private final String code;

    @Column(name = "text", nullable = false)
    private final String text;
}
