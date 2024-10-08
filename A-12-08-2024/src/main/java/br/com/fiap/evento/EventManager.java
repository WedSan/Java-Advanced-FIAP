package br.com.fiap.evento;

import br.com.fiap.evento.exception.EventNotFoundException;

import java.util.List;
import java.util.Map;

public interface EventManager {

    void addEvent(Event event);

    void removeEvent(String eventName) throws EventNotFoundException;

    List<Event> listEventsByCategory(EventCategory category);

    Map<EventCategory, Long> countEventsByCategory();

    long countTotalParticipants();

    Map<String, Long> countParticipantsByEvent();

    Map<String, Long> countParticipantsByEventOrdered();

    Event findEvent(String eventName) throws EventNotFoundException;

}
