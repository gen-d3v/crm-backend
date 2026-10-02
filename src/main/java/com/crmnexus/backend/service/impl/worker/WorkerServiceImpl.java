package com.crmnexus.backend.service.impl.worker;

import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.WorkerResponse;
import com.crmnexus.backend.entities.WorkerEntity;
import com.crmnexus.backend.repository.WorkerRepository;
import com.crmnexus.backend.service.impl.AesGcmEncryptionService;
import com.crmnexus.backend.service.interfaces.worker.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
 private AesGcmEncryptionService encryptionService;
 private WorkerRepository workerRepo;

    public WorkerServiceImpl(AesGcmEncryptionService encryptionService, WorkerRepository workerRepo) {
        this.encryptionService = encryptionService;
        this.workerRepo = workerRepo;
    }

    @Override
    public WorkerResponse createWorker(WorkerRequest worker) {
        String encryptedGender = encryptionService.encrypt(worker.gender());
        String encryptedFirstName = encryptionService.encrypt(worker.firstName());
        String encryptedNamePrefix = encryptionService.encrypt(worker.namePrefix());
        String encryptedLastName = encryptionService.encrypt(worker.lastName());
        String encryptedBirthDate = encryptionService.encrypt(worker.birthDate());
        String encryptedZipCode = encryptionService.encrypt(worker.zipCode());
        String encryptedHouseNumber = encryptionService.encrypt(worker.houseNumber());
        String encryptedPhoneNumber = encryptionService.encrypt(worker.phoneNumber());
        String encryptedEmail = encryptionService.encrypt(worker.email());
        String encryptedPersonalIdNumber = encryptionService.encrypt(worker.personalIdNumber());
        String encryptedEmploymentType = encryptionService.encrypt(worker.employmentType().name());

        WorkerEntity workerEntity = new WorkerEntity(
                encryptedBirthDate,
                encryptedEmail,
                encryptedFirstName,
                encryptedGender,
                encryptedHouseNumber,
                encryptedLastName,
                encryptedNamePrefix,
                encryptedPersonalIdNumber,
                encryptedPhoneNumber,
                encryptedZipCode,
                encryptedEmploymentType
        );

        workerRepo.save(workerEntity);


        return new WorkerResponse("Worker created successfully");
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
