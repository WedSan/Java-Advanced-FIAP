package br.com.fiap.evento;

import br.com.fiap.evento.exception.EventNotFoundException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventManagerImpl implements EventManager {

    private List<Event> events;

    public EventManagerImpl() {
        this.events = new ArrayList<>();
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public void removeEvent(String eventName) throws EventNotFoundException {
        Event eventToRemove = events
                .stream()
                .filter(event -> event.getName().equalsIgnoreCase(eventName))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Event not found with the name: " + eventName));

        events.remove(eventToRemove);
    }

    @Override
    public List<Event> listEventsByCategory(EventCategory category) {
        List<Event> eventsByCategory = new ArrayList<>();
        for (Event event : events) {
            if (event.getCategory() == category) {
                eventsByCategory.add(event);
            }
        }

        return eventsByCategory;
    }

    @Override
    public Map<EventCategory, Long> countEventsByCategory() {
        return Map.of();
    }

    @Override
    public long countTotalParticipants() {
        return events.stream()
                .flatMap(event -> event.listParticipants().stream())
                .count();
    }

    @Override
    public Map<String, Long> countParticipantsByEvent() {
        return events.stream()
        	.collect(
        			Collectors.groupingBy(e -> e.getName(),
					Collectors.summingLong(e -> e.listParticipants().size()))
        			);
    }

    @Override
    public Map<String, Long> countParticipantsByEventOrdered() {
        return countParticipantsByEvent()
        		.entrySet()
        		.stream()
        		.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    @Override
    public Event findEvent(String eventName) throws EventNotFoundException {
        return events.stream()
        		.filter(e -> e.getName().equalsIgnoreCase(eventName))
        		.findFirst()
        		.orElseThrow(() -> new EventNotFoundException("The event with name: " + eventName + "doesn't exist in the events list"));
    }
}