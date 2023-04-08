package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.model.Bug;

public interface BugService {
    Bug findByIdOrElseThrow(long id);
    void save(Bug bug);
}
