package com.crmnexus.backend.service.interfaces.worker;

import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.WorkerResponse;

public interface WorkerService {
    WorkerResponse createWorker(WorkerRequest worker);
    WorkerRequest retrieveWorker(WorkerRequest worker);
    WorkerResponse updateWorker(WorkerRequest worker);
    WorkerResponse deleteWorker(WorkerRequest worker);

}
