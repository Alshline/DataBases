package TestValuesPostgreDB.service;

import TestValuesPostgreDB.model.TestValue;
import TestValuesPostgreDB.reporitory.TestValueRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TestService implements TestServiceInterface{

    @Autowired
    TestValueRepository testValueRepository;


    @Override
    public Optional<TestValue> getById(Long id) {
        log.info("TestService -> getByID",id);
        return testValueRepository.findById(id);
    }

    @Override
    public void save(TestValue testValue) {
        log.info("TestService -> save",testValue);
        testValueRepository.save(testValue);
    }

    @Override
    public void deleteById(Long id) {
        log.info("TestService -> deleteById",id);
        testValueRepository.deleteById(id);
    }

    @Override
    public List<TestValue> getAll() {
        log.info("TestService -> getAll");
        return testValueRepository.findAll();
    }
}
