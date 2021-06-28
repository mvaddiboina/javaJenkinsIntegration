pipeline {
    agent any
    stages {
        stage('clone repo and cleam') {
            steps {
                bat "mvn clean"
            }
        }      
         stage('Test') {
            steps {
                bat "mvn test"
            }
        }
    }
}