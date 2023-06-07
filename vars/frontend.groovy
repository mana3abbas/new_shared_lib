def call (){
    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/client:l${BUILD_NUMBER} -f $WORKSPACE/tree/frontend/badreads-frontend
                            docker push monasamir/client:l${BUILD_NUMBER}
                          """
}
