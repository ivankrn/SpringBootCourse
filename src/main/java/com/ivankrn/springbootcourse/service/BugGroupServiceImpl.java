package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.controller.NotFoundException;
import com.ivankrn.springbootcourse.database.BugGroupRepository;
import com.ivankrn.springbootcourse.model.BugGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BugGroupServiceImpl implements BugGroupService {

    private final BugGroupRepository bugGroupRepository;

    @Override
    public BugGroup findByIdOrElseThrow(long id) {
        return bugGroupRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void save(BugGroup bugGroup) {
        bugGroupRepository.save(bugGroup);
    }
}
