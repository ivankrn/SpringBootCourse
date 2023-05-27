package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.controller.NotFoundException;
import com.ivankrn.springbootcourse.database.BugGroupDto;
import com.ivankrn.springbootcourse.database.BugGroupRepository;
import com.ivankrn.springbootcourse.database.MapStructMapper;
import com.ivankrn.springbootcourse.event.BugGroupCreatedEvent;
import com.ivankrn.springbootcourse.model.BugGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BugGroupServiceImpl implements BugGroupService {

    private final BugGroupRepository bugGroupRepository;
    private final MapStructMapper mapStructMapper;
    private final ApplicationEventPublisher publisher;

    @Override
    public BugGroupDto findByIdOrElseThrow(long id) {
        BugGroup bugGroup = bugGroupRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return mapStructMapper.bugGroupToBugGroupDto(bugGroup);
    }

    @Override
    @Transactional
    public void save(BugGroupDto bugGroupDto) {
        BugGroup bugGroup = mapStructMapper.bugGroupDtoToBugGroup(bugGroupDto);
        bugGroupRepository.save(bugGroup);
        publisher.publishEvent(new BugGroupCreatedEvent(bugGroupDto.getName(), bugGroupDto.getBugs().size()));
    }
}
