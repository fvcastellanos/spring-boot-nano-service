package net.cavitos.benchmark.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Resource {

    String id();
    String value();
}