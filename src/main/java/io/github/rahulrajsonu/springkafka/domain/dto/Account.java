package io.github.rahulrajsonu.springkafka.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    private String holder;
    private String funds;

    public Account(
            @JsonProperty String holder,
            @JsonProperty String funds) {
        this.holder = holder;
        this.funds = funds;
    }

    public Account() {
    }
}