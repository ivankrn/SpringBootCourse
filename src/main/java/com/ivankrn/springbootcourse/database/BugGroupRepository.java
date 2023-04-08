package com.ivankrn.springbootcourse.database;

import com.ivankrn.springbootcourse.model.BugGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugGroupRepository extends CrudRepository<BugGroup, Long> {
}
