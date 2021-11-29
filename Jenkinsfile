pipeline {
    agent {
        docker{
            steps {
          sh "docker --version"          }

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