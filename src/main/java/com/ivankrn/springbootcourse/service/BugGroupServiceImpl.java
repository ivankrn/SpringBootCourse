package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.controller.NotFoundException;
import com.ivankrn.springbootcourse.database.BugGroupDto;
import com.ivankrn.springbootcourse.database.BugGroupRepository;
import com.ivankrn.springbootcourse.database.MapStructMapper;
import com.ivankrn.springbootcourse.model.BugGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BugGroupServiceImpl implements BugGroupService {

    private final BugGroupRepository bugGroupRepository;
    private final MapStructMapper mapStructMapper;

    @Override
    public BugGroupDto findByIdOrElseThrow(long id) {
        BugGroup bugGroup = bugGroupRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return mapStructMapper.bugGroupToBugGroupDto(bugGroup);
    }

    @Override
    public void save(BugGroupDto bugGroupDto) {
        BugGroup bugGroup = mapStructMapper.bugGroupDtoToBugGroup(bugGroupDto);
        //bugGroup.getBugs().forEach(b -> b.setGroup(bugGroup));
        bugGroupRepository.save(bugGroup);
    }
}
