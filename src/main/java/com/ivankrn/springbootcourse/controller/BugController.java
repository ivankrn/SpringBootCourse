package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.database.BugDto;
import com.ivankrn.springbootcourse.service.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/bugs")
@RequiredArgsConstructor
public class BugController {

    private final BugService bugService;

    @GetMapping("/{id}")
    public BugDto getById(@PathVariable long id) {
        return bugService.findByIdOrElseThrow(id);
    }

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<Map<String, String>> save(@RequestBody @Valid BugDto bugDto, Authentication authentication) {
        bugService.save(bugDto);
        Map<String, String> response = new HashMap<>();
        response.put("username", authentication.getName());
        response.put("role", authentication.getAuthorities().toString());
        return ResponseEntity.ok().body(response);
    }

}
