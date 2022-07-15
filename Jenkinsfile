pipeline{
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('jenkins-dockerhub')
    }
    stages{
        stage('Build maven'){
                steps {
                    sh 'pwd'
                    sh 'mvn clean install'
                }
            }
        stage('Build'){
            steps {
                sh 'docker-compose build'
            }
        }
        stage('Login'){
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push'){
            steps{
                sh 'docker push "${dockerhub_main}:latest" '
            }
        }
    }
}
