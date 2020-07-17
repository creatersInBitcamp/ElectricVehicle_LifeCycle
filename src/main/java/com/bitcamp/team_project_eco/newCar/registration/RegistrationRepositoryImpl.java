package com.bitcamp.team_project_eco.newCar.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface RegistrationRepository extends JpaRepository<Registration,Long>,RegistrationService{}

interface RegistrationService {}

public class RegistrationRepositoryImpl extends QuerydslRepositorySupport implements RegistrationService {

    public RegistrationRepositoryImpl() {
        super(Registration.class);
    }
}
