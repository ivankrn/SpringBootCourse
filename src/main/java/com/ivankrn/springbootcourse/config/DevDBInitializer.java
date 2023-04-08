package com.ivankrn.springbootcourse.config;

import com.ivankrn.springbootcourse.model.Bug;
import com.ivankrn.springbootcourse.model.BugGroup;
import com.ivankrn.springbootcourse.service.BugGroupService;
import com.ivankrn.springbootcourse.service.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class DevDBInitializer implements CommandLineRunner {
    private final BugGroupService bugGroupService;
    private final BugService bugService;

    @Override
    public void run(String... args) throws Exception {
        BugGroup frontendGroup = new BugGroup();
        frontendGroup.setName("Frontend");
        bugGroupService.save(frontendGroup);
        BugGroup backendGroup = new BugGroup();
        backendGroup.setName("Backend");
        bugGroupService.save(backendGroup);
        Bug loginButtonBug = new Bug();
        loginButtonBug.setTitle("Login button doesn't work");
        loginButtonBug.setSeverity(3);
        loginButtonBug.setGroup(frontendGroup);
        bugService.save(loginButtonBug);
        Bug wrongMenuLocationBug = new Bug();
        wrongMenuLocationBug.setTitle("Wrong menu button location");
        wrongMenuLocationBug.setSeverity(3);
        wrongMenuLocationBug.setGroup(frontendGroup);
        bugService.save(wrongMenuLocationBug);
        Bug endpointBug = new Bug();
        endpointBug.setTitle("Endpoint is broken");
        endpointBug.setSeverity(0);
        endpointBug.setGroup(backendGroup);
        bugService.save(endpointBug);
    }

}
