pipeline{
    agent none
    environment {
        DOCKERHUB_CREDANTIALS = credantials('jenkins-dockerhub')
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
                sh 'echo $DOCKERHUB_CREDANTIALS_PSW | docker login -u $DOCKERHUB_CREDANTIALS_USR --password-stdin'
            }
        }
        stage('Push'){
            sh 'docker push'
        }
    }
}
