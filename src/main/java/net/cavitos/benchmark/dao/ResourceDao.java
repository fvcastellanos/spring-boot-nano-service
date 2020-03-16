package net.cavitos.benchmark.dao;

import java.util.List;
import java.util.Optional;

import net.cavitos.benchmark.model.Resource;

public interface ResourceDao {

    List<Resource> getResources();
    Resource newResource(String value);
    Optional<Resource> getResource(String id);
}