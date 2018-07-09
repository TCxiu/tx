package test.service.api.service;

import org.springframework.web.bind.annotation.*;
import test.service.api.model.Test;
import java.util.List;

public interface TestService {

    @PostMapping("/test")
    Boolean addTest(@RequestBody Test test);

    @DeleteMapping("/test/{id}")
    Boolean delTestById(@PathVariable(value = "id") Long id);

    @PutMapping("/test/{id}")
    Boolean updateTestById(@PathVariable(value = "id") Long id,@RequestBody Test record);

    @GetMapping("/test/{id}")
    Test findById(@PathVariable(value = "id") Long id);

    @GetMapping("/test")
    List<Test> listTest();
}
