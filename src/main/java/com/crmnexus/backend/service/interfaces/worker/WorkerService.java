package com.crmnexus.backend.service.interfaces.worker;

import com.crmnexus.backend.dto.request.CreateWorkerRequest;
import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.GetWorkerResponse;
import com.crmnexus.backend.dto.response.WorkerResponse;

import java.util.List;

public interface WorkerService {
    WorkerResponse createWorker(CreateWorkerRequest worker);
    GetWorkerResponse retrieveWorker(WorkerRequest worker);
    WorkerResponse updateWorker(WorkerRequest worker);
    WorkerResponse deleteWorker(WorkerRequest worker);
    List<GetWorkerResponse> retrieveAllWorkers();

}
