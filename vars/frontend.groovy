def call (){
    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            git branch: 'frontend', url: 'https://github.com/mana3abbas/new_shared_lib/tree/frontend'
                            docker build -t monasamir/client:l${BUILD_NUMBER} -f $WORKSPACE/badreads-frontend/ 
                            docker push monasamir/client:l${BUILD_NUMBER}
                          """
}
