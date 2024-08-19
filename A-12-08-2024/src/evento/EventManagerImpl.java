package evento;

import evento.exception.EventNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventManagerImpl implements EventManager {

    private List<EventImpl> events;

    public EventManagerImpl() {
        this.events = new ArrayList<>();
    }

    @Override
    public void addEvent(EventImpl event) {
        events.add(event);
    }

    @Override
    public void removeEvent(String eventName) throws EventNotFoundException {
        EventImpl eventToRemove = events
                .stream()
                .filter(event -> event.getName().equalsIgnoreCase(eventName))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Event not found with the name: " + eventName));

        events.remove(eventToRemove);
    }

    @Override
    public List<Event> listEventsByCategory(EventCategory category) {
        List<Event> eventsByCategory = new ArrayList<>();
        for (EventImpl event : events) {
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
        return Map.of();
    }

    @Override
    public Map<String, Long> countParticipantsByEventOrdered() {
        return Map.of();
    }

    @Override
    public Event findEvent(String eventName) {
        return null;
    }
}