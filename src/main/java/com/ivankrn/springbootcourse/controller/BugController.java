package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.aspect.Limit;
import com.ivankrn.springbootcourse.database.BugDto;
import com.ivankrn.springbootcourse.service.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public void save(@RequestBody @Valid BugDto bugDto) {
        bugService.save(bugDto);
    }

}
