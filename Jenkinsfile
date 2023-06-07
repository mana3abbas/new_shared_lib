@Library('shared-lib') _
 @Library('shared-lib@frontend')_
 @Library('shared-lib@backend')_
 @Library('shared-lib@helm')_
pipeline {
    agent { label 'jenkins-slave' }
     
    stages {
        stage('build') {
                
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
