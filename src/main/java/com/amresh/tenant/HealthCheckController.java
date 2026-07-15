package com.amresh.tenant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController()
@RequestMapping("/")
public class HealthCheckController {
   @GetMapping
    public ResponseEntity<HashMap<String, String> > healthStatus(){

    HashMap<String,String> message = new HashMap<>();
    message.put("status","Active");
    message.put("message","Yes It working fine!");
    return ResponseEntity.ok(message);
    }
}
