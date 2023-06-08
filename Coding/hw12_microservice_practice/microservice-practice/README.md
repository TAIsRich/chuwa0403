# Microservice application learning

- API Gateway
- Eureka
- Hystrix 

# Tutorial Video 



https://m.youtube.com/watch?v=nElpCWmpSew&list=PLyHJZXNdCXsd2e3NMW9sZbto8RB5foBtp&index=1

Estimated time: 105 minutes;

## Create Database 
CitizenService
VaccinationCenter 

# Eureka Server Service 

service name: EurekaServer url: http://localhost:8761/

remember to visit the url and check the Eureka page, you will see the service in that page
## Dependency

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>


## Configuration 
server:
    port:   
        8761
eureka:
    client:
        fetch-registry: false
        register-with-eureka: false

## Code 
Only need to add @EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

# Citizen Servie 



# VaccinationCenter Service 

Enable CircuitBreaker and LoadBalanced

@SpringBootApplication
@EnableCircuitBreaker
public class VaccinationCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

Call another service

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequiredResponse> getAllDataBasedonCenterId(@PathVariable Integer id) {

        RequiredResponse response = new RequiredResponse();
        //get vaccination center detail
        VaccinationCenter center = centerRepository.findById(id).get();
        response.setCenter(center);

        //then get all citizen registered in that center
        List<Citizen> listCitizen = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
        response.setCitizens(listCitizen);
        return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);

    }

    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id) {

        RequiredResponse response = new RequiredResponse();
        //get vaccination center detail
        VaccinationCenter center = centerRepository.findById(id).get();
        response.setCenter(center);

        return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);
    }
}

  

