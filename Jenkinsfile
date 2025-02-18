pipeline {
    agent any

    environment {
        // Define any environment variables you need here
        // For example, if you want to define a Java home variable:
        JAVA_HOME = '/path/to/java'
    }

    stages {
        // Stage 1: Checkout the code from your Git repository
        stage('Checkout') {
            steps {
                // Checkout the code from Git repository
                git branch: 'main', url: 'https://github.com/codemaster170/LayoutCard.git'
                // Ensure you're using the correct branch name here
            }
        }

        // Stage 2: Clean and Build the Maven project
        stage('Build') {
            steps {
                script {
                    // Run Maven clean install to build the project
                    sh 'mvn clean install'
                }
            }
        }

        // Stage 3: Run Unit Tests
        stage('Test') {
            steps {
                script {
                    // Run Maven tests with Surefire
                    sh 'mvn test'
                }
            }
        }

        // Stage 4: Publish Test Results
        stage('Publish Test Results') {
            steps {
                // Publish JUnit test results
                junit '**/target/test-classes/*.xml' // Ensure this matches your test result location
            }
        }

        // Stage 5: Archive Artifacts (Optional, if you want to keep the build jar)
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        // Actions that will happen after the pipeline run
        success {
            echo 'Build and tests successful!'
        }
        failure {
            echo 'Build or tests failed.'
        }
        always {
            // Actions that always run after the pipeline, regardless of success/failure
            echo 'Cleaning up or running post-build tasks.'
            // Add any clean-up steps here, like removing temporary files or notifying users
        }
    }
}



