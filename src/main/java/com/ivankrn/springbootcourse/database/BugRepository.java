package com.ivankrn.springbootcourse.database;

import com.ivankrn.springbootcourse.model.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {

    int SEVERITY_LIMIT = 10;

    @Query("select count(*) from Bug b where b.severity " +
            "< com.ivankrn.springbootcourse.database.BugRepository.SEVERITY_LIMIT")
    long getUncriticalBugsCount();

    @Query("select count(*) from Bug b where b.severity " +
            "= com.ivankrn.springbootcourse.database.BugRepository.SEVERITY_LIMIT")
    long getCriticalBugsCount();
}
