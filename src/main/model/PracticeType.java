package main.model;

import java.util.Arrays;
import java.util.List;

public enum PracticeType {
    FREESTYLE(Arrays.asList("50 Free", "100 Free", "200 Free")),
    IM(Arrays.asList("100 IM", "200 IM", "400 IM")),
    STROKE(Arrays.asList("100 Fly", "100 Back", "100 Breast"));

    private final List<String> events;

    PracticeType(List<String> events) {
        this.events = events;
    }

    public List<String> getEvents() {
        return events;
    }
}
