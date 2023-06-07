@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
             
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                    git(
                    url: "https://github.com/mana3abbas/new_shared_lib/tree/frontend/badreads-frontend",
                    branch: "frontend",
                    changelog: true,
                    poll: true
                )
          
                      frontend ()
                        
                   }
                }
            }
        }
         stage('deploy') {
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                   
                       helm ()
                }
                  }
            }
    }
}
