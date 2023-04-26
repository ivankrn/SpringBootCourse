package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.database.BugGroupDto;

public interface BugGroupService {
    BugGroupDto findByIdOrElseThrow(long id);
    void save(BugGroupDto bugGroupDto);
}
