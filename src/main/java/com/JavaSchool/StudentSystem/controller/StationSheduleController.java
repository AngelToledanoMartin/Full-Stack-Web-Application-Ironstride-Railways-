package com.JavaSchool.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


//import java.util.List;

//import com.JavaSchool.StudentSystem.model.Shedule;
import com.JavaSchool.StudentSystem.service.StationSheduleService;

@RestController
@RequestMapping("/stationShedule")
@CrossOrigin

public class StationSheduleController {

    @Autowired
    private StationSheduleService stationSheduleService;

/* 
    @GetMapping("/search")
    public List<Shedule> getAllShedule() {
        return stationSheduleService.getAllShedule(@RequestParam String variable1);
    }
    */
    
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(stationSheduleService.search(filter));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+ e.getMessage()+ "\"}"));

        }
    }
    
}
    /* 
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(stationSheduleService.search(filter));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+ e.getMessage()+ "\"}"));

        }
    }
    
}
*/
