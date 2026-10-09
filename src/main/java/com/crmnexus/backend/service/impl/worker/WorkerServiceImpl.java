package com.crmnexus.backend.service.impl.worker;

import com.crmnexus.backend.dto.request.CreateWorkerRequest;
import com.crmnexus.backend.dto.request.WorkerRequest;
import com.crmnexus.backend.dto.response.GetWorkerResponse;
import com.crmnexus.backend.dto.response.WorkerResponse;
import com.crmnexus.backend.entities.WorkerEntity;
import com.crmnexus.backend.enums.EmploymentType;
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
    public WorkerResponse createWorker(CreateWorkerRequest worker) {
        String encryptedGender = encryptionService.encrypt(worker.gender());
        String encryptedFirstName = encryptionService.encrypt(worker.firstName());

        String encryptedNamePrefix = null;

        if (worker.namePrefix() != null)  {
            encryptedNamePrefix = encryptionService.decrypt(worker.namePrefix());
        }        String encryptedLastName = encryptionService.encrypt(worker.lastName());

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
    public GetWorkerResponse retrieveWorker(WorkerRequest worker) {
        WorkerEntity workerEntity = workerRepo.findById(worker.id()).orElseThrow(() -> new IllegalArgumentException("No worker found"));



        Long id = workerEntity.getId();
        String decryptedGender = encryptionService.decrypt(workerEntity.getGender());
        String decryptedFirstName = encryptionService.decrypt(workerEntity.getFirstName());

        String decryptedNamePrefix = null;

        if (workerEntity.getNamePrefix() != null)  {
            decryptedNamePrefix = encryptionService.decrypt(workerEntity.getNamePrefix());
        }


        String decryptedLastName = encryptionService.decrypt(workerEntity.getLastName());
        String decryptedBirthDate = encryptionService.decrypt(workerEntity.getBirthDate());
        String decryptedZipCode = encryptionService.decrypt(workerEntity.getZipCode());
        String decryptedHouseNumber = encryptionService.decrypt(workerEntity.getHouseNumber());
        String decryptedPhoneNumber = encryptionService.decrypt(workerEntity.getPhoneNumber());
        String decryptedEmail = encryptionService.decrypt(workerEntity.getEmail());
        String decryptedPersonalIdNumber = encryptionService.decrypt(workerEntity.getPersonalIdNumber());
        String decryptedEmploymentType = encryptionService.decrypt(workerEntity.getEmploymentType());

        EmploymentType employmentType = EmploymentType.valueOf(decryptedEmploymentType);

        return new GetWorkerResponse(
                id,
                decryptedGender,
                decryptedFirstName,
                decryptedNamePrefix,
                decryptedLastName,
                decryptedBirthDate,
                decryptedZipCode,
                decryptedHouseNumber,
                decryptedPhoneNumber,
                decryptedEmail,
                decryptedPersonalIdNumber,
                employmentType

        );
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
