package com.crmnexus.backend.service.interfaces.worker;

import com.crmnexus.backend.dto.Worker;

public interface WorkerService {
    Boolean createWorker(Worker worker);
    Worker retrieveWorker(Worker worker);
    Boolean updateWorker(Worker worker);
    Boolean deleteWorker(Worker worker);

}
