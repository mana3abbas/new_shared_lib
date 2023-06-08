def call(String param1, String param2){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                             git url: 'https://github.com/mana3abbas/${param2}-shared.git', branch: 'main'
                            docker build -t monasamir"${param1}":s${BUILD_NUMBER} -f $WORKSPACE/badreads-"${param2}"/ .
                            docker push monasamir/"${param1}":s${BUILD_NUMBER} 
                       """
}

