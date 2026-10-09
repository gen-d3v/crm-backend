package com.crmnexus.backend.dto.response;

import com.crmnexus.backend.enums.EmploymentType;

public record  GetWorkerResponse (Long id,
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
