pipeline {
    agent {
        docker{
            withCredentials([
            usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'DockerHub_PASSWORD',
            usernameVariable: 'DockerHub_USER')]) {
            image 'maven:3.8.4-openjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}