def call (){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            when {
                        env.BRANCH_NAME==backend
                        }
                            docker build -t monasamir/server:b${BUILD_NUMBER} -f $WORKSPACE/badreads-backend/
                            docker push monasamir/server:b${BUILD_NUMBER} 
                       """
}
