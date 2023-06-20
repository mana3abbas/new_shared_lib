def call(){
          
                sh """
                         echo "Running Helm"
                         helm install vois${BUILD_NUMBER} ./chart
                   """   
}
