@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
               when {
                        branch 'frontend'
                      }
                
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                
          
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
