package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.database.BugGroupDto;
import com.ivankrn.springbootcourse.model.BugGroup;
import com.ivankrn.springbootcourse.service.BugGroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bug_groups")
@RequiredArgsConstructor
public class BugGroupController {

    private final BugGroupService bugGroupService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public BugGroupDto getById(@PathVariable long id) {
        return convertToDto(bugGroupService.findByIdOrElseThrow(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid BugGroupDto bugGroupDto) {
        bugGroupService.save(convertToEntity(bugGroupDto));
    }

    private BugGroupDto convertToDto(BugGroup bugGroup) {
        BugGroupDto bugGroupDto = modelMapper.map(bugGroup, BugGroupDto.class);
        return bugGroupDto;
    }

    private BugGroup convertToEntity(BugGroupDto bugGroupDto) {
        BugGroup bugGroup = modelMapper.map(bugGroupDto, BugGroup.class);
        return bugGroup;
    }
}
