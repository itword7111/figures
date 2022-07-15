pipeline{
    agent {label 'мастер'}
    environment {
        DOCKERHUB_CREDENTIALS = credentials('jenkins-dockerhub')
    }
    stages{
        stage('Build'){
            steps {
                sh 'docker-compose build'
                sh 'docker-compose up'
            }
        }
        stage('Login'){
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push'){
            steps{
                sh 'docker push'
            }
        }
    }
}
