package com.crmnexus.backend.service.impl.worker;

import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.WorkerResponse;
import com.crmnexus.backend.service.impl.AesGcmEncryptionService;
import com.crmnexus.backend.service.interfaces.worker.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
 private AesGcmEncryptionService encryptionService;

    public WorkerServiceImpl(AesGcmEncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public WorkerResponse createWorker(WorkerRequest worker) {
        return null;
    }

    @Override
    public WorkerRequest retrieveWorker(WorkerRequest worker) {
        return null;
    }

    @Override
    public WorkerResponse updateWorker(WorkerRequest worker) {
        return null;
    }

    @Override
    public WorkerResponse deleteWorker(WorkerRequest worker) {
        return null;
    }


}
