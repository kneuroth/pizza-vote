package com.kneuroth.pizza_vote.data.entry;

import org.springframework.boot.context.properties.bind.DefaultValue;

public record Entry(int id, String name, String creator, @DefaultValue("2025") int year) {
}
