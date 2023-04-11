package com.ivankrn.springbootcourse.config;

import com.ivankrn.springbootcourse.database.BugGroupRepository;
import com.ivankrn.springbootcourse.database.BugRepository;
import com.ivankrn.springbootcourse.model.Bug;
import com.ivankrn.springbootcourse.model.BugGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class DevDBInitializer implements CommandLineRunner {
    private final BugGroupRepository bugGroupRepository;
    private final BugRepository bugRepository;

    @Override
    public void run(String... args) throws Exception {
        BugGroup frontendGroup = new BugGroup();
        frontendGroup.setName("Frontend");
        bugGroupRepository.save(frontendGroup);
        BugGroup backendGroup = new BugGroup();
        backendGroup.setName("Backend");
        bugGroupRepository.save(backendGroup);
        Bug loginButtonBug = new Bug();
        loginButtonBug.setTitle("Login button doesn't work");
        loginButtonBug.setSeverity(3);
        loginButtonBug.setGroup(frontendGroup);
        bugRepository.save(loginButtonBug);
        Bug wrongMenuLocationBug = new Bug();
        wrongMenuLocationBug.setTitle("Wrong menu button location");
        wrongMenuLocationBug.setSeverity(3);
        wrongMenuLocationBug.setGroup(frontendGroup);
        bugRepository.save(wrongMenuLocationBug);
        Bug endpointBug = new Bug();
        endpointBug.setTitle("Endpoint is broken");
        endpointBug.setSeverity(0);
        endpointBug.setGroup(backendGroup);
        bugRepository.save(endpointBug);
    }

}
