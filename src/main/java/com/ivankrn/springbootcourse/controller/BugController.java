package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.aspect.Limit;
import com.ivankrn.springbootcourse.database.BugDto;
import com.ivankrn.springbootcourse.database.UserInfoDto;
import com.ivankrn.springbootcourse.service.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/bugs")
@RequiredArgsConstructor
@Limit
public class BugController {

    private final BugService bugService;

    @GetMapping("/{id}")
    public BugDto getById(@PathVariable long id) {
        return bugService.findByIdOrElseThrow(id);
    }

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<UserInfoDto> save(@RequestBody @Valid BugDto bugDto, Authentication authentication) {
        bugService.save(bugDto);
        UserInfoDto userInfo = new UserInfoDto(authentication.getName(), authentication.getAuthorities().toString());
        return ResponseEntity.ok().body(userInfo);
    }

}
