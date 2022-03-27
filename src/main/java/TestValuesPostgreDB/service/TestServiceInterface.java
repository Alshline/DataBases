package TestValuesPostgreDB.service;

import TestValuesPostgreDB.model.TestValue;

import java.util.List;
import java.util.Optional;

public interface TestServiceInterface {

    Optional<TestValue> getById (Long id);

    void save (TestValue testValue);

    void deleteById(Long id);

    List <TestValue> getAll();
}
