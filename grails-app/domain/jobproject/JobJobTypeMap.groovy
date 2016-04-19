package jobproject

class JobJobTypeMap {

    Long jobId
    Long jobTypeId

    String jobTitle
    String jobTypeName

    static transients = ['jobTitle', 'jobTypeName']
    static constraints = {
        //...
    }
}
