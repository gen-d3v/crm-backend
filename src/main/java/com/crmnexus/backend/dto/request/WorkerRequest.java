package com.crmnexus.backend.dto.request;

public record WorkerRequest(String gender,
                            String firstName,
                            String namePrefix,
                            String lastName,
                            String birthDate,
                            String zipCode,
                            String houseNumber,
                            String phoneNumber,
                            String email,
                            String personalIdNumber) {
}
