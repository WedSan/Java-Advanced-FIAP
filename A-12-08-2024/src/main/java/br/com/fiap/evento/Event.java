package br.com.fiap.evento;

import br.com.fiap.evento.exception.ParticipantAlreadyExistsException;
import br.com.fiap.evento.exception.ParticipantNotFoundException;

import java.util.Set;

public interface Event {

    void addParticipants(String participant) throws ParticipantAlreadyExistsException;

    void removeParticipants(String participants) throws ParticipantNotFoundException;

    Set<String> listParticipants();

    long countParticipants();

    Set<String> listParticipantsOrdered();

    String getName();

    EventCategory getCategory();
}
