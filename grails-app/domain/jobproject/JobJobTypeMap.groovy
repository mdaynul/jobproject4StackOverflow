package jobproject

class JobJobTypeMap {

    Long jobId
    Long jobTypeId

    String jobTitle
    String jobTypeName

    static transients = ['jobTitle', 'jobTypeName']
//    static constraints = {
//        jobTitle bindable:true
//        jobTypeName bindable:true
//        //...
//    }
//
//    public String getJobTitle(){
//        return this.jobTitle
//    }
//    public String getJobTypeName(){
//        return this.jobTypeName
//    }
}
