package org.ebi.bess.person.query.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.ebi.bess.person.core.dto.BaseResponse;
import org.ebi.bess.person.core.models.Person;

public class UserLookupResponse extends BaseResponse {
    private List<Person> users;

    public UserLookupResponse(String message) {
        super(message);
    }

    public UserLookupResponse(List<Person> users) {
        super(null);
        this.users = users;
    }

    public UserLookupResponse(String message, Person user) {
        super(message);
        this.users = new ArrayList<>();
        this.users.add(user);
    }

    public UserLookupResponse(Person user) {
        super(null);
        this.users = new ArrayList<>();
        this.users.add(user);
    }

    public List<Person> getUsers() {
        return this.users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }
}
