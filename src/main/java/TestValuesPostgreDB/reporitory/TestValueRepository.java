package TestValuesPostgreDB.reporitory;

import TestValuesPostgreDB.model.TestValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link TestValue} class.
 */

public interface TestValueRepository extends JpaRepository<TestValue,Long> {

}
