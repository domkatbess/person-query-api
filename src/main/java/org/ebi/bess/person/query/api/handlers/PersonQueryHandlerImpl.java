package org.ebi.bess.person.query.api.handlers;

import java.util.ArrayList;

import org.axonframework.queryhandling.QueryHandler;
import org.ebi.bess.person.query.api.dto.UserLookupResponse;
import org.ebi.bess.person.query.api.queries.FindAllUsersQuery;
import org.ebi.bess.person.query.api.queries.FindUserByIdQuery;
import org.ebi.bess.person.query.api.queries.SearchUsersQuery;
import org.ebi.bess.person.query.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonQueryHandlerImpl implements PersonQueryHandler {
    private final UserRepository userRepository;

    @Autowired
    public PersonQueryHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    @Override
    public UserLookupResponse getUserById(FindUserByIdQuery query) {
        var user = userRepository.findById(query.getId());
        return user.isPresent() ? new UserLookupResponse(user.get()) : null;
    }

    @QueryHandler
    @Override
    public UserLookupResponse searchUsers(SearchUsersQuery query) {
        var users = new ArrayList<>(userRepository.findByFilterRegex(query.getFilter()));
        return new UserLookupResponse(users);
    }

    @QueryHandler
    @Override
    public UserLookupResponse getAllUsers(FindAllUsersQuery query) {
        var users = new ArrayList<>(userRepository.findAll());
        return new UserLookupResponse(users);
    }
}
