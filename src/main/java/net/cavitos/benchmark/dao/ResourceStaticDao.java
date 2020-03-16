package net.cavitos.benchmark.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Lists;

import net.cavitos.benchmark.model.ImmutableResource;
import net.cavitos.benchmark.model.Resource;

public class ResourceStaticDao implements ResourceDao {

    private static final List<Resource> RESOURCES = Lists.newArrayList(
        buildResource("Element 1"),
        buildResource("Element 2"),        
        buildResource("Element 3"),        
        buildResource("Element 4"),        
        buildResource("Element 5"),        
        buildResource("Element 6"),        
        buildResource("Element 7"),        
        buildResource("Element 8"),        
        buildResource("Element 9"),        
        buildResource("Element 10"));

    @Override
    public List<Resource> getResources() {
        return RESOURCES;
    }   

    @Override
    public Resource newResource(String value) {

        var resource = buildResource(value);
        RESOURCES.add(resource);

        return resource;
    }

    @Override
    public Optional<Resource> getResource(String id) {

        return RESOURCES.stream()
            .filter(resource -> resource.id().equals(id))
            .findFirst();
    }

    private static Resource buildResource(String value) {

        return ImmutableResource.builder()
            .id(UUID.randomUUID().toString())
            .value(value)
            .build();
    }
}