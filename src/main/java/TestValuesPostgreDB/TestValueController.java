package TestValuesPostgreDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "http://localhost:8081")
@RestController
@Controller
public class TestValueController {

    @Autowired
    private TestValueRepository testValueRepository;

    @GetMapping("/TestValues")
    public ResponseEntity<List<TestValue>> getAllTestValues(@RequestParam(required = false) Integer id){
        try {
            List<TestValue> testValueList = new ArrayList<TestValue>();
            if (id==null)
                testValueRepository.findAll().forEach(testValueList::add);
            else
                testValueRepository.findAllById(id).forEach(testValueList::add);
            if (testValueList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(testValueList, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/TestValues/{id}")
    public ResponseEntity<TestValue> getTestValueById(@PathVariable("id") Integer id){
        Optional<TestValue> optionalTestValue = testValueRepository.findById(id);
        if (optionalTestValue.isPresent())
            return new ResponseEntity<>(optionalTestValue.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/TestValues")
    public ResponseEntity<TestValue> createTestValue(@RequestBody TestValue testValue){
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
            return new ResponseEntity<>(postTestValue,HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("/TestValues/{id}")
    public ResponseEntity<TestValue> updateTestValues (@PathVariable("id") Integer id, @RequestBody TestValue testValue){
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

            return new ResponseEntity<>(testValueRepository.save(putTestValue),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/TestValues/{id}")
    public ResponseEntity<HttpStatus> deleteTestValue (@PathVariable("id") Integer id){
        try {
            testValueRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/TestValues")
    public ResponseEntity<HttpStatus> deleteAllTestValue (){
        try {
            testValueRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

/*
@GetMapping("/TestValues")
    public String listAll (Model model){
        List<TestValue> testValueList = testValueRepository.findAll();
        model.addAttribute("testValueList", testValueList);

        return "testValueList";
 */