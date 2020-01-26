#!/usr/bin/env groovy

def callS3Upload(mesg){
  stage("${mesg}") {

 s3Upload consoleLogLevel: 'INFO', dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'jenkins-ashu', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: '**/Build*/*.war', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'mobile-s3-user', userMetadata: []

  }
}

def artifactory(){
  callS3Upload("Upload to S3")
}

return this;

