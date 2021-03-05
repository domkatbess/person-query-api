package org.ebi.bess.person.query.api.handlers;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.ebi.bess.person.core.events.PersonCreatedEvent;
import org.ebi.bess.person.core.events.PersonRemovedEvent;
import org.ebi.bess.person.core.events.PersonUpdatedEvent;
import org.ebi.bess.person.query.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("user-group")
public class PersonEventHandlerImpl implements PersonEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public PersonEventHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    @Override
    public void on(PersonCreatedEvent event) {
        userRepository.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(PersonUpdatedEvent event) {
        userRepository.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(PersonRemovedEvent event) {
        userRepository.deleteById(event.getId());
    }
}
