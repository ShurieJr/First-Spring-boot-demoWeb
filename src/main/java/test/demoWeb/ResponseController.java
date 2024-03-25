package test.demoWeb;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    //get ok
    @GetMapping("/")
    public ResponseEntity getOk() {
        //200
        return ResponseEntity.ok("Seccessfully!");
    }

    @GetMapping("/created")
    public ResponseEntity getCreated() {
        //201 status code
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }


    @GetMapping("badRequest")
    public ResponseEntity getBadRequest() {
        //400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }

    @GetMapping("notFound")
    public ResponseEntity getNotFound() {
        //404 status code
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    @GetMapping("/customStatus")
    public ResponseEntity getCustomStatus() {
        //202 status code
        return new ResponseEntity<>("Custom status", HttpStatus.ACCEPTED);
    }

    @GetMapping("/error")
    public ResponseEntity getError() {
        Map<String, String> error = new HashMap<>();
        error.put("Error", "Error message");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @GetMapping("/withHeaders")
    public ResponseEntity getWithHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("error with headers", "Error message");
        return ResponseEntity.ok().headers(headers).body("Response with headers");
    }
}

