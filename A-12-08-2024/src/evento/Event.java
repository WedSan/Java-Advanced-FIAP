package evento;

import java.util.Set;

public interface Event {

    void addParticipants(String participant) throws ParticipantAlreadyExistsException;

    void removeParticipants(String participants);

    Set<String> listParticipants();

    long countParticipants();

    Set<String> listParticipantsOrdered();
}
