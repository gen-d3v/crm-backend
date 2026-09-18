package com.crmnexus.backend.controller.worker;

import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.WorkerResponse;
import com.crmnexus.backend.service.interfaces.worker.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    @PostMapping("/create")
    ResponseEntity<WorkerResponse> createWorker(@Valid @RequestBody WorkerRequest workerReq) {
        WorkerResponse response = workerService.createWorker(workerReq);

        return ;
    }

    }
