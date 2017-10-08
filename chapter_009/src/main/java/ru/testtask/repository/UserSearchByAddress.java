package ru.testtask.repository;

import ru.testtask.model.Address;

/**
 * Created by nikolay on 08/10/17.
 */
public class UserSearchByAddress implements ISpecification {
    /**
     * address.
     */
    private Address address;
    /**
     * Constructor.
     * @param addr - address.
     */
    public UserSearchByAddress(Address addr) {
        this.address = addr;
    }

    @Override
    public String toSqlClauses() {
        return String.format(" where city = '%s' and street = '%s' and num = '%s';", address.getCity(), address.getStreet(), address.getNumber());
    }
}
