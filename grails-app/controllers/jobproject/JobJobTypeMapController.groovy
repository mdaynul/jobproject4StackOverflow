package jobproject

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.hibernate.SQLQuery
import org.hibernate.Session
import grails.transaction.Transactional

@Transactional(readOnly = true)
class JobJobTypeMapController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def dataSource

    def getList() {

        def params = [column:"job.title", order:'DESC', offset:0, limit:5]

        Sql sql = new Sql(dataSource)
        String query = """
            SELECT  job_job_type_map.job_id jobId, job_job_type_map.job_type_id jobTypeId,
                    job.title jobTitle, jobType.name jobTypeName
            FROM    job job, job_type jobType, job_job_type_map job_job_type_map
            WHERE   job_job_type_map.job_id = job.id
            AND     job_job_type_map.job_type_id = jobType.id
            ORDER BY ${params.column} ${params.order}
            LIMIT   :limit
            OFFSET  :offset
        """

        List<GroovyRowResult> result  = sql.rows(query, params)
        result.each {
            println "${it.jobId} ${it.jobTypeId} ${it.jobTitle} ${it.jobTypeName}"
        }

        render template: 'list', model: [jobRows:result]
    }

    def sessionFactory

    def getSecondList() {

        def result = JobJobTypeMap.executeQuery("""
            SELECT  JobJobTypeMap.id as id, JobJobTypeMap.version as version,
            JobJobTypeMap.jobId as jobId, JobJobTypeMap.jobTypeId as jobTypeId,
            Job.title as jobTitle, JobType.name as jobTypeName
            FROM    JobJobTypeMap JobJobTypeMap, Job Job, JobType JobType
            WHERE JobJobTypeMap.jobId = Job.id AND JobJobTypeMap.jobTypeId = JobType.id

        """)

        result.each{
            println "${it[0]} ${it[1]} ${it[2]} ${it[3]} ${it[4]} ${it[5]}"
        }
//        render template: 'list', model: [jobRows:result]
    }

    def getThirdList() {

        String queryStr = """
            SELECT  job_job_type_map.id id, job_job_type_map.version version,
            job_job_type_map.job_id jobId, job_job_type_map.job_type_id jobTypeId,
                    job.title job_title, jobType.name job_type_name
            FROM    Job job, Job_Type jobType, job_job_type_map job_job_type_map
            WHERE   job_job_type_map.job_id = job.id
            AND     job_job_type_map.job_type_id = jobType.id
        """
        Session session = sessionFactory.currentSession
        SQLQuery query = session.createSQLQuery(queryStr);
        query.addEntity(JobMapModel.class);

        List<JobMapModel> jobJobTypeMapList = query.list()
        jobJobTypeMapList.each{
            println "${it.jobId} ${it.jobTypeId} ${it.jobTitle} ${it.jobTypeName}"

        }

    }

}
