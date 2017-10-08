package ru.testtask.repository;

import ru.testtask.model.User;

import java.util.List;

/**
 * Created by nikolay on 08/10/17.
 */
public interface IUserRepository {
    /**
     * Query.
     * @param spec - spec.
     * @return - result.
     */
    List<User> query(ISpecification spec);
}
