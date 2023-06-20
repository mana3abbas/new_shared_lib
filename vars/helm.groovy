def call(){
          if
          
                sh """
                   echo "Running Helm"
                   helm install client${BUILD_NUMBER} ./resources/chart  --values ./resources/chart/client.yaml
                   """  
          if 

                 sh """
                   echo "Running Helm"
                   helm install server${BUILD_NUMBER} ./resources/chart  --values ./resources/chart/server.yaml
                   """  
}
