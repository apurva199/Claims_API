node{
   stage("Git Clone"){

        git branch: 'master', url: 'https://github.com/apurva199/Claims_API.git'
    }
   
    stage("Docker build"){
    sh 'docker build -t apurva09/myclaims_image:latest .'
        sh 'docker image ls'
    }

    withCredentials([string(credentialsId: 'apurva09', variable: 'PASSWORD')]) {
        sh 'docker login -u apurva09 -p $PASSWORD'
    }

    stage("Pushing Image to Docker Hub"){
     
       sh 'docker push apurva09/myclaims_image:latest'
       }
    post {
        always {
            script {
                if (getContext(hudson.FilePath)) {
                    deleteDir()
                }
            }
        }
    }
}
