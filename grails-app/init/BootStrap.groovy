import jobproject.Job
import jobproject.JobJobTypeMap
import jobproject.JobType

class BootStrap {

    def init = { servletContext ->

        Job job1 = new Job(title: "Software Eng Job").save(flush:true)
        Job job2 = new Job(title: "Network Eng Job").save(flush:true)
        Job job3 = new Job(title: "Sys Admin Job").save(flush:true)
        Job job4 = new Job(title: "Another Software Eng").save(flush:true)

        JobType jobType1 = new JobType(name: "Permanent").save(flush: true)
        JobType jobType2 = new JobType(name: "Contractual").save(flush: true)

        new JobJobTypeMap(jobId: job1.id, jobTypeId: jobType1.id).save(flush: true)
        new JobJobTypeMap(jobId: job2.id, jobTypeId: jobType1.id).save(flush: true)
        new JobJobTypeMap(jobId: job3.id, jobTypeId: jobType1.id).save(flush: true)
        new JobJobTypeMap(jobId: job4.id, jobTypeId: jobType1.id).save(flush: true)
        new JobJobTypeMap(jobId: job1.id, jobTypeId: jobType2.id).save(flush: true)
        new JobJobTypeMap(jobId: job2.id, jobTypeId: jobType2.id).save(flush: true)
        new JobJobTypeMap(jobId: job3.id, jobTypeId: jobType2.id).save(flush: true)
        new JobJobTypeMap(jobId: job4.id, jobTypeId: jobType2.id).save(flush: true)

    }
    def destroy = {
    }
}
