pipeline {
agent any
tools {
maven 'Fita maven'
jdk 'jdk21'
}
stages {
stage('Checkout') {
steps {
git branch: 'main',
url: 'https://github.com/zachadgar/maven-demo.git'
}
}
stage('Build') {
steps {
sh 'mvn clean compile'
}
}
stage('Test') {
steps {
sh 'mvn test'
}
post {
always {
junit 'target/surefire-reports/*.xml'
}
}
}
stage('Package') {
steps {
sh 'mvn package'
}
}
stage('Archive') {
steps {
archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
}
}
}
post {
success {
echo 'Pipeline completed successfully!'
}
failure {
echo 'Pipeline failed. Check console output above.'
}
}
}