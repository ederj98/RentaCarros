pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
          $class: 'GitSCM',
          branches: [[name: '*/development']],
          doGenerateSubmoduleConfigurations: false,
          extensions: [],
          gitTool: 'Default',
          submoduleCfg: [],
          userRemoteConfigs: [[
            credentialsId: 'GitHub_ederj98',
            url:'https://github.com/ederj98/RentaCarros.git'
          ]]
        ])
      }
    }
    
    stage('Build') {
      steps {
        echo "------------>Build<------------"
        dir("CarClick"){
          sh 'gradle --b ./build.gradle build -x test'
        }
      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
        dir("CarClick"){
          sh 'gradle --b ./build.gradle clean'
          sh 'gradle --b ./build.gradle test jacocoTestReport'
        }
      }
    }  

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
            sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'eder.fernandez@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
            body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
      mail (to: 'eder.fernandez@ceiba.com.co', subject: "Changed Pipeline:${currentBuild.fullDisplayName}",
            body: "Something changed with ${env.BUILD_URL}")
    }
  }
}
