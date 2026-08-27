package com.crmnexus.backend.service.interfaces.worker;

import com.crmnexus.backend.dto.Worker;

public interface WorkerService {
    Boolean CreateWorker(Worker worker);
    Worker RetrieveWorker(Worker worker);
    Boolean UpdateWorker(Worker worker);
    Boolean DeleteWorker(Worker worker);

}
