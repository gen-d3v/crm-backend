package com.crmnexus.backend.controller.worker;

import com.crmnexus.backend.dto.request.CreateWorkerRequest;
import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.GetWorkerResponse;
import com.crmnexus.backend.dto.response.WorkerResponse;
import com.crmnexus.backend.service.interfaces.worker.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    @PostMapping("/create-worker")
    ResponseEntity<WorkerResponse> createWorker(@Valid @RequestBody CreateWorkerRequest workerReq) {
        WorkerResponse response = workerService.createWorker(workerReq);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/get-worker")
    ResponseEntity<GetWorkerResponse> getWorker(@Valid @RequestBody WorkerRequest worker) {
        GetWorkerResponse request = workerService.retrieveWorker(worker);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(request);
    }


    }
