import com.chuwa.CitizenService.entity.Citizen;
import com.chuwa.CitizenService.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        List<Citizen> listCitizen = citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity<>(listCitizen, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
        Citizen citizen = citizenRepository.save(newCitizen);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }
}