def call(String param1){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir"${param1}":s${BUILD_NUMBER} -f  .
                            docker push monasamir/"${param1}":s${BUILD_NUMBER} 
                       """
}
