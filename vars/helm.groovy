def call(){
          if
          
                sh """
                   echo "Running Helm"
                   helm install web${BUILD_NUMBER} ./resources/chart  --values ./resources/chart/client.yaml
                   """  
          if 

                 sh """
                   echo "Running Helm"
                   helm install web${BUILD_NUMBER} ./resources/chart  --values ./resources/chart/server.yaml
                   """  
}
