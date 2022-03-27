package TestValuesPostgreDB.rest;

import TestValuesPostgreDB.model.TestValue;
import TestValuesPostgreDB.reporitory.TestValueRepository;
import TestValuesPostgreDB.service.TestServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "http://localhost:8081")
@RestController
@Controller
@RequestMapping("/TestValues")
public class TestValueController {

    @Autowired
    private TestValueRepository testValueRepository;

    @GetMapping("{id}")
    public ResponseEntity<TestValue> getTestValueById(@PathVariable("id") Long id){
        if (id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<TestValue> optionalTestValue = testValueRepository.findById(id);
        if (optionalTestValue.isPresent())
            return new ResponseEntity<>(optionalTestValue.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<TestValue> createTestValue(@RequestBody TestValue testValue){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (testValue == null){
            return new ResponseEntity<TestValue>(HttpStatus.BAD_REQUEST);
        }
        try{
            TestValue postTestValue = testValueRepository
                    .save(new TestValue(testValue.getEmptyCapWeight(),
                            testValue.getFullCapWeight(),
                            testValue.getHitch(),
                            testValue.getCompHeight(),
                            testValue.getFullHeight(),
                            testValue.getActuationTime(),
                            testValue.getImas(),
                            testValue.getIlin(),
                            testValue.getDensity()));
            return new ResponseEntity<>(postTestValue,httpHeaders,HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("{id}")
    public ResponseEntity<TestValue> updateTestValues (@PathVariable("id") Long id, @RequestBody TestValue testValue){
        HttpHeaders httpHeaders = new HttpHeaders();
        Optional<TestValue> optionalTestValue = testValueRepository.findById(id);
        if (optionalTestValue.isPresent()){
            TestValue putTestValue = optionalTestValue.get();
            putTestValue.setEmptyCapWeight(testValue.getEmptyCapWeight());
            putTestValue.setFullCapWeight(testValue.getFullCapWeight());
            putTestValue.setHitch(testValue.getHitch());
            putTestValue.setCompHeight(testValue.getCompHeight());
            putTestValue.setFullHeight(testValue.getFullHeight());
            putTestValue.setActuationTime(testValue.getActuationTime());
            putTestValue.setImas(testValue.getImas());
            putTestValue.setIlin(testValue.getIlin());
            putTestValue.setDensity(testValue.getDensity());
            return new ResponseEntity<>(testValueRepository.save(putTestValue),httpHeaders,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<HttpStatus> deleteTestValue (@PathVariable("id") Long id){
        try {
            testValueRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<TestValue>> getAllTestValues(){
        try {
            List<TestValue> testValueList = new ArrayList<TestValue>();
            testValueRepository.findAll().forEach(testValueList::add); //functional interface need to rework (::add)
            if (testValueList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(testValueList, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("")
    public ResponseEntity<HttpStatus> deleteAllTestValues (){
        try {
            testValueRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}