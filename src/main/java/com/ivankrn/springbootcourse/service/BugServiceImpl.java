package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.controller.NotFoundException;
import com.ivankrn.springbootcourse.database.BugDto;
import com.ivankrn.springbootcourse.database.BugRepository;
import com.ivankrn.springbootcourse.database.MapStructMapper;
import com.ivankrn.springbootcourse.event.BugCreatedEvent;
import com.ivankrn.springbootcourse.model.Bug;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;
    private final MapStructMapper mapStructMapper;
    private final KafkaProducerService kafkaProducerService;
    private final ApplicationEventPublisher publisher;

    @Override
    public BugDto findByIdOrElseThrow(long id) {
        Bug bug = bugRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return mapStructMapper.bugToBugDto(bug);
    }

    @Override
    public void save(BugDto bugDto) {
        bugRepository.save(mapStructMapper.bugDtoToBug(bugDto));
        kafkaProducerService.send(bugDto);
        publisher.publishEvent(new BugCreatedEvent(bugDto.getTitle(), bugDto.getSeverity()));
    }
}
