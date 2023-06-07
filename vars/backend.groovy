def call (name,fname){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/${name}:b${BUILD_NUMBER} -f $WORKSPACE/badreads-${fname}/Dockerfile  
                            docker push monasamir/${name}:b${BUILD_NUMBER} 
                       """
}
