@Library('shared-lib') _
 
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
                
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                     repo_call(main,backend)
                     build (server,backend)
                     repo_call(main,frontend)

                     build (client,frontend)

                   }
                }
            }
        }
         stage('deploy') {
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                    repo_call(main,helm)

                       helm ()
                }
                  }
            }
    }
}
