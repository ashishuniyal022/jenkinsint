#!/usr/bin/env groovy

def callS3Upload(mesg){
  stage("${mesg}") {
    withAWS(credentials:'mobile-s3-user',region:'ap-south-1'){s3Upload(acl:'PublicRead',bucket:'mybucket-ssp',cacheControl:'',excludePathPattern:'',file:"Build-${env.BUILD_NUMBER}",metadatas:[''],path:"${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}")
    }
  }
}

def artifactory(){
  callS3Upload("Upload to S3")
}

return this;
