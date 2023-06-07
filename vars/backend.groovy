def call (){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/server:s${BUILD_NUMBER} -f $WORKSPACE/badreads-backend/
                            docker push monasamir/server:s${BUILD_NUMBER} 
                       """
}
