pipeline {
 agent none
    stages {
         stage('Docker maven') {
              agent any
              steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHub',
                 passwordVariable: 'DockerHubPassword', usernameVariable: 'DockerHubUser')]) {
                  sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPassword}"
                  }
            }
        }
        }
    }