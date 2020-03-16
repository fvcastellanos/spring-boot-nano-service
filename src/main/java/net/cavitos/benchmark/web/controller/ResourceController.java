package net.cavitos.benchmark.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cavitos.benchmark.model.Resource;
import net.cavitos.benchmark.service.ResourceService;
import net.cavitos.benchmark.web.view.ResourceView;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(final ResourceService resourceService) {

        this.resourceService = resourceService;
    }

    @GetMapping
    public ResponseEntity getResources() {

        final var result = resourceService.getResources();

        if (result.isLeft()) {

            return new ResponseEntity<>(result.getLeft(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        final var views = buildResourceViews(result.get());

        return new ResponseEntity<>(views, HttpStatus.OK);
    }

    public List<ResourceView> buildResourceViews(final List<Resource> resources) {

        return resources.stream()
            .map(resource -> new ResourceView(resource.id(), resource.value()))
            .collect(Collectors.toList());
    }
}