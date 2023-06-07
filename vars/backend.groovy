def call (){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/${name}:b${BUILD_NUMBER} -f $WORKSPACE/badreads-backend/Dockerfile  
                            docker push monasamir/${name}:b${BUILD_NUMBER} 
                       """
}
