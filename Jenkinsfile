node{
   stage("Git Clone"){

        git branch: 'master', url: 'https://github.com/apurva199/Claims_API.git'
    }
   
    stage("Docker build"){
    sh 'docker build -t jsilaparasetti/app-2-img:latest .'
        sh 'docker image ls'
    }

    withCredentials([string(credentialsId: 'ineeladri', variable: 'PASSWORD')]) {
        sh 'docker login -u ineeladri -p $PASSWORD'
    }

    stage("Pushing Image to Docker Hub"){
     
       sh 'docker push ineeladri/app-2-img:latest'
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
