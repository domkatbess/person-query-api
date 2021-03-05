package org.ebi.bess.person.query.api.handlers;

import org.ebi.bess.person.core.events.PersonCreatedEvent;
import org.ebi.bess.person.core.events.PersonRemovedEvent;
import org.ebi.bess.person.core.events.PersonUpdatedEvent;

public interface PersonEventHandler {
    void on(PersonCreatedEvent event);
    void on(PersonUpdatedEvent event);
    void on(PersonRemovedEvent event);
}
