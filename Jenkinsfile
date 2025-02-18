pipeline {
    agent any

    environment {
        MVN_HOME = tool 'Maven'  // Ensure Maven is installed in Jenkins Global Tool Configuration
        JAVA_HOME = tool 'JDK21'  // Use JDK 21 for your project, or ensure it's available
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/codemaster170/work5.git'  // Replace with your actual GitHub repo URL
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                script {
                    sh "${MVN_HOME}/bin/mvn clean install -DskipTests"  // Skipping tests during build
                }
            }
        }

        stage('Test') {
            steps {
                // Run the tests using Maven
                script {
                    sh "${MVN_HOME}/bin/mvn test"
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive the jar file as a build artifact
                archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.jar', followSymlinks: false
            }
        }
    }

    post {
        success {
            // Notify success
            echo 'Build and tests successful!'
        }

        failure {
            // Notify failure
            echo 'Build or tests failed. Please check the logs.'
        }
    }
}



