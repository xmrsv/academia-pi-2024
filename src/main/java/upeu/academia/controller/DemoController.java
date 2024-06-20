package upeu.academia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Adrian
 */
@RestController
@RequestMapping(path = "/api/v1")
public class DemoController {

    @PostMapping(value = "/demo")
    public String demo() {
        return "Welcome to secured enpoint!";
    }
}
