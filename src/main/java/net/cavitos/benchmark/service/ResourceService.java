package net.cavitos.benchmark.service;

import java.util.List;

import io.vavr.control.Either;
import io.vavr.control.Try;
import net.cavitos.benchmark.dao.ResourceDao;
import net.cavitos.benchmark.model.Resource;

public class ResourceService {

    private ResourceDao resourceDao;

    public ResourceService(ResourceDao resourceDao) {

        this.resourceDao = resourceDao;
    }

    public Either<String, List<Resource>> getResources() {

        return Try.of(() -> resourceDao.getResources())
            .toEither()
            .mapLeft(Throwable::getMessage);
    }

    public Either<String, Resource> newResource(String value) {

        return Try.of(() -> resourceDao.newResource(value))
            .toEither()
            .mapLeft(Throwable::getMessage);
    }

    public Either<String, Resource> getResource(String id) {

        return Try.of(() -> { 

            var resourceHolder = resourceDao.getResource(id);

            if (resourceHolder.isEmpty()) {

                throw new RuntimeException("resource not found");
            }

            return resourceHolder.get();
        }).toEither()
            .mapLeft(Throwable::getMessage);
    }
}