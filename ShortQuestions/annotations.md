# SpringBootApplication
@SpringBootApplication: This annotation is used to mark the main class of a Spring Boot application. It is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.
``` java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```
# Controller
@Controller: This annotation is used to mark a class as a Spring MVC controller.
``` java
@Controller
public class MyController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "hello";
    }
}
```

# RestController
@RestController: This annotation is used to mark a class as a Spring MVC controller that returns data in the form of a RESTful web service.
``` java
@RestController
public class MyRestController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, world!";
    }
}
```

# RequestMapping
@RequestMapping: This annotation is used to map HTTP requests to specific controller methods.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
```

# GetMapping
@GetMapping: This annotation is a specialized version of @RequestMapping that is used to handle HTTP GET requests.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
```

# PostMapping
@PostMapping: This annotation is a specialized version of @RequestMapping that is used to handle HTTP POST requests.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @PostMapping("/submit")
    public String submitData(@RequestBody MyData data) {
        // save the data to the database
        return "Data submitted successfully!";
    }
}
```

# PutMapping
@PutMapping: This annotation is a specialized version of @RequestMapping that is used to handle HTTP PUT requests.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @PutMapping("/update/{id}")
    public String updateData(@PathVariable Long id, @RequestBody MyData data) {
        // update the data with the given id in the database
        return "Data updated successfully!";
    }
}
```

# DeleteMapping
@DeleteMapping: This annotation is a specialized version of @RequestMapping that is used to handle HTTP DELETE requests.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable Long id) {
        // delete the data with the given id from the database
        return "Data deleted successfully!";
    }
}
```

# RequestParam
@RequestParam: This annotation is used to extract query parameters from a URL.
``` java
@RestController
@RequestMapping("/api")
public class MyRestController {
    @GetMapping("/find")
    public String findData(@RequestParam(name = "id") Long id) {
        // find the data with the given id in the database
        return "Data found successfully!";
    }
}
```




@PathVariable: This annotation is used to extract path variables from a URL.