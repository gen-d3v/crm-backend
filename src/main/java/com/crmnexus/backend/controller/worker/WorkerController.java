package com.crmnexus.backend.controller.worker;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WorkerController {
    public WorkerController() {
    }

    @PostMapping("/create")
    Boolean createWorker() {
//        if (!) return false;

        return true;
    }

}