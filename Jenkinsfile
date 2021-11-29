pipeline {
 agent none
    stages {
         stage('Docker maven') {
              agent any
              steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHub',
                 passwordVariable: 'DockerHubPassword', usernameVariable: 'DockerHubUser')]) {
                  sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPassword}"}
            image 'maven:3.8.4-openjdk-11'
            args '-v /root/.m2:/root/.m2'

              }
          }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}