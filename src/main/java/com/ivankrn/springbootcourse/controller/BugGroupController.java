package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.aspect.Limit;
import com.ivankrn.springbootcourse.database.BugGroupDto;
import com.ivankrn.springbootcourse.service.BugGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bug_groups")
@RequiredArgsConstructor
@Limit
public class BugGroupController {

    private final BugGroupService bugGroupService;

    @GetMapping("/{id}")
    public BugGroupDto getById(@PathVariable long id) {
        return bugGroupService.findByIdOrElseThrow(id);
    }

    @PostMapping
    public void save(@RequestBody @Valid BugGroupDto bugGroupDto) {
        bugGroupService.save(bugGroupDto);
    }

}
