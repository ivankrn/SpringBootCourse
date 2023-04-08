package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.database.BugDto;
import com.ivankrn.springbootcourse.model.Bug;
import com.ivankrn.springbootcourse.service.BugService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/bugs")
@RequiredArgsConstructor
public class BugController {

    private final BugService bugService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public BugDto getById(@PathVariable long id) {
        return convertToDto(bugService.findByIdOrElseThrow(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid BugDto bugDto) {
        bugService.save(convertToEntity(bugDto));
    }

    private BugDto convertToDto(Bug bug) {
        BugDto bugDto = modelMapper.map(bug, BugDto.class);
        return bugDto;
    }

    private Bug convertToEntity(BugDto bugDto) {
        Bug bug = modelMapper.map(bugDto, Bug.class);
        return bug;
    }
}
