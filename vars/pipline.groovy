@Library('new_shared_lib') _
def call(
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
                
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                    
                     build ("server","backend")

                   }
                }
            }
        }
      
    }
}
  )
