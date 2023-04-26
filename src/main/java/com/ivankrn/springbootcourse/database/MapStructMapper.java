package com.ivankrn.springbootcourse.database;

import com.ivankrn.springbootcourse.model.Bug;
import com.ivankrn.springbootcourse.model.BugGroup;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface MapStructMapper {
    BugDto bugToBugDto(Bug bug);
    Bug bugDtoToBug(BugDto bugDto);
    BugSlimDto bugToBugSlimDto(Bug bug);
    Bug bugSlimDtoToBug(BugSlimDto bugSlimDto);
    BugGroupDto bugGroupToBugGroupDto(BugGroup bugGroup);
    BugGroup bugGroupDtoToBugGroup(BugGroupDto bugGroupDto);
    BugGroupSlimDto bugGroupToBugGroupSlimDto(BugGroup bugGroup);
    BugGroup bugGroupSlimDtoToBugGroup(BugGroupSlimDto bugGroupSlimDto);
}
