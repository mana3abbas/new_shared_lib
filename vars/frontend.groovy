def call (){
    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            git branch: 'backend', url: 'https://github.com/mana3abbas/new_shared_lib/tree/backend'
                            docker build -t monasamir/client:l${BUILD_NUMBER} -f $WORKSPACE/badreads-frontend/Dockerfile  
                            docker push monasamir/client:l${BUILD_NUMBER}
                          """
}
