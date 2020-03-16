package net.cavitos.benchmark.web.view;

public class ResourceView {

    private String id;
    private String value;

    public ResourceView(String id, String value) {

        this.id = id;
        this.value = value;
    }

    public String getId() {

        return id;
    }

    public String getValue() {

        return value;
    }
}