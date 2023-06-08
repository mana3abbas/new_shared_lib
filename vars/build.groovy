def call(String param1, String param2){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/"${param1}":s${BUILD_NUMBER} -f $WORKSPACE/badreads-"${param2}"/Dockerfile
                            docker push monasamir/"${param1}":s${BUILD_NUMBER} 
                       """
}

