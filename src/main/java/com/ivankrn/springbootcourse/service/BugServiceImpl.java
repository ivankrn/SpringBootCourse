package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.controller.NotFoundException;
import com.ivankrn.springbootcourse.database.BugRepository;
import com.ivankrn.springbootcourse.model.Bug;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    @Override
    public Bug findByIdOrElseThrow(long id) {
        return bugRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void save(Bug bug) {
        bugRepository.save(bug);
    }
}
