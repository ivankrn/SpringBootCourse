package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.database.BugDto;

public interface BugService {
    BugDto findByIdOrElseThrow(long id);

    void save(BugDto bugDto);
}
