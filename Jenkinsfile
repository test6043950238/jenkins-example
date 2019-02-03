pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                sh 'mvn build'
            }
        }

        stage ('Testing Stage') {
            steps {
                sh 'mvn test'
            }
        }
    }
}