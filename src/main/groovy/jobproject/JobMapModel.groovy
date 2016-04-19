package jobproject

import grails.persistence.Entity

/**
 * Created by aynul on 4/20/16.
 */
@Entity
class JobMapModel {
    Long id
    Integer version
    Long jobId
    String jobTitle
    Long jobTypeId
    String jobTypeName
}
