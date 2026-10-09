package com.crmnexus.backend.dto.request;

import com.crmnexus.backend.enums.EmploymentType;

public record CreateWorkerRequest(
                            String gender,
                            String firstName,
                            String namePrefix,
                            String lastName,
                            String birthDate,
                            String zipCode,
                            String houseNumber,
                            String phoneNumber,
                            String email,
                            String personalIdNumber,
                            EmploymentType employmentType) {
}
