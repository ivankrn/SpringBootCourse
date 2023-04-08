package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.database.BugGroupDto;
import com.ivankrn.springbootcourse.database.MapStructMapper;
import com.ivankrn.springbootcourse.model.BugGroup;
import com.ivankrn.springbootcourse.service.BugGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bug_groups")
@RequiredArgsConstructor
public class BugGroupController {

    private final BugGroupService bugGroupService;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/{id}")
    public BugGroupDto getById(@PathVariable long id) {
        BugGroup bugGroup = bugGroupService.findByIdOrElseThrow(id);
        BugGroupDto bugGroupDto = mapStructMapper.bugGroupToBugGroupDto(bugGroup);
        return mapStructMapper.bugGroupToBugGroupDto(bugGroupService.findByIdOrElseThrow(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid BugGroupDto bugGroupDto) {
        BugGroup bugGroup = mapStructMapper.bugGroupDtoToBugGroup(bugGroupDto);
        //bugGroup.getBugs().forEach(b -> b.setGroup(bugGroup));
        bugGroupService.save(bugGroup);
    }

}
