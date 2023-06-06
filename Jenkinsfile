@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
      parameters {
         choice(name: 'build', choices: [dev,test,prod], description: 'choose a value')
       }
    stages {
        stage('build') {
             when {
                branch 'backend'
              }
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                     backend ()
                        
                   }
                }
            }
        }
         stage('deploy') {
             when {
                branch 'helm'
              }
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                   
                       helm ()
                }
                  }
            }
    }
}
