def call(String param1){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/s:${BUILD_NUMBER} .
                            docker push monasamir/s:${BUILD_NUMBER} 
                       """
}

