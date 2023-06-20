def call(String param1){
          
          
                sh """
                   echo "Running Helm"
                   helm install ${param1}${BUILD_NUMBER} ./resources/chart  --values ./resources/chart/${param1}.yaml
                   """  
           
}
