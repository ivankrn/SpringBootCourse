package com.ivankrn.springbootcourse.database;

import com.ivankrn.springbootcourse.model.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {
}
