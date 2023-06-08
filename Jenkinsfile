@Library('shared-lib') _
 
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
                
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                     repo_call.Clone ("main","https://github.com/mana3abbas/backend-shared.git")
                     build ("server","backend")
                     repo_call.Clone("main","https://github.com/mana3abbas/frontend-shared-.git")

                     build ("client","frontend")

                   }
                }
            }
        }
         stage('deploy') {
          
            steps {
               script {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                    repo_call.Clone ("main","https://github.com/mana3abbas/helm-shared.git")
                       helm ()
                }
                  }
            }
         }
    }
}
