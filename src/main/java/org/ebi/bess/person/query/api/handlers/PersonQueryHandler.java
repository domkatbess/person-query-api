package org.ebi.bess.person.query.api.handlers;

import org.ebi.bess.person.query.api.dto.UserLookupResponse;
import org.ebi.bess.person.query.api.queries.FindAllUsersQuery;
import org.ebi.bess.person.query.api.queries.FindUserByIdQuery;
import org.ebi.bess.person.query.api.queries.SearchUsersQuery;

public interface PersonQueryHandler {
    UserLookupResponse getUserById(FindUserByIdQuery query);
    UserLookupResponse searchUsers(SearchUsersQuery query);
    UserLookupResponse getAllUsers(FindAllUsersQuery query);
}
