@Library('new_shared_lib') _
 
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
                
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                   git url: 'https://github.com/mana3abbas/frontend-shared-.git', branch: 'main'
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
                       helm ()
                }
                  }
            }
         }
    }
}
