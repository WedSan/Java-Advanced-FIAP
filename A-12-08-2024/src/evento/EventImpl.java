package evento;

import evento.exception.ParticipantAlreadyExistsException;
import evento.exception.ParticipantNotFoundException;
import jdk.jfr.Category;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class EventImpl implements Event{

    private String name;

    private LocalDateTime date;

    private EventCategory category;

    private Set<String> participants;



    public EventImpl(String name, LocalDateTime date, EventCategory category, Set<String> participants) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.participants = participants;
    }

    @Override
    public void addParticipants(String participant) throws ParticipantAlreadyExistsException {
        if(!participants.add(participant)){
            throw new ParticipantAlreadyExistsException("Participant: " + participant + "already exists in the list");
        }
    }

    @Override
    public void removeParticipants(String participant) throws ParticipantNotFoundException {
        try{
            if(this.participants.remove(participant)){
                throw new ParticipantAlreadyExistsException("Participant: " + participant + " doesn't exist in the list");
            }
        }
        catch(ParticipantAlreadyExistsException ex){
            System.out.println("was not possible remove the participant. Reason: " + ex.getMessage() );
        }

    }

    @Override
    public Set<String> listParticipants() {
        return this.participants;
    }

    @Override
    public long countParticipants() {
        return this.participants.size();
    }

    @Override
    public Set<String> listParticipantsOrdered() {
        return this.participants.stream()
                .sorted()
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }
}
