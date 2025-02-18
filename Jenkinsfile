pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk' // Update this path based on your server's Java installation
        PATH = "$JAVA_HOME/bin:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/codemaster170/work5.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Running tests and generating reports
                    sh 'mvn verify'
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'  // Make sure this matches the location of your test reports
            }
        }

        stage('Package') {
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: false
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed. Check logs for details.'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs() // Cleans the workspace after execution
        }
    }
}

