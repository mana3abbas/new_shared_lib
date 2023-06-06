@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
      parameters {
         choice(name: 'build', choices: [dev,test,prod], description: 'choose a value')
       }
    stages {
        stage('build') {
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                       
                     git "https://github.com/mana3abbas/new_shared_lib/tree/backend"
                        backend ()
                       git branch: 'frontend'
                       url: "https://github.com/mana3abbas/new_shared_lib/tree/frontend"
                       frontend ()
                   }
                }
            }
        }
         stage('deploy') {
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                     git branch: 'backend'
                     url: "https://github.com/mana3abbas/new_shared_lib/tree/helm"
                     helm ()
                }
                  }
            }
    }
}
