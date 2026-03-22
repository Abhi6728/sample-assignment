package com.abhi.sample_assignment.controller;

import com.abhi.sample_assignment.entity.Request;
import com.abhi.sample_assignment.service.DataService;
import com.abhi.sample_assignment.service.QueueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

    private final QueueService queueService;
    private final DataService dataService;


    public RequestController(QueueService queueService, DataService dataService) {
        this.queueService = queueService;
        this.dataService = dataService;
    }

    @PostMapping(value = "/submit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> submit(@Valid @RequestBody Request request){
        queueService.enqueue(request);
        return ResponseEntity.ok("Request queued");
    }


    @GetMapping(value = "/data/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> getData(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(dataService.getData(id));
    }

    @GetMapping("/data")
    public ResponseEntity<List<Request>> getAllData(){
        return ResponseEntity.ok(dataService.getAllData());
    }
}
