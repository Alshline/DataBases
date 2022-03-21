package TestValuesPostgreDB;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestValueRepository extends JpaRepository<TestValue,Integer> {

    List<TestValue> findAllById(int id);
}
