package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.model.BugGroup;

public interface BugGroupService {
    BugGroup findByIdOrElseThrow(long id);
    void save(BugGroup bugGroup);
}
