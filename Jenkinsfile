pipeline {
	agent any
	//agent { docker { image 'maven:3.6.3' } }
	environment{
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	
	stages{
		stage('Checkout') {
			steps{
				sh 'mvn --version'
				sh 'docker version'
				echo "Build"
				echo "$PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
			}
		}

		stage('clean') {
			steps{
				sh 'mvn clean '
			}
		}

		stage('Static Code Analysis') {
        			steps{
        				sh 'mvn pmd:pmd'
        				sh 'mvn checkstyle:checkstyle'
        				sh 'mvn findbugs:findbugs'
        			}
        		}

        stage('Publish Static Code Analysis') {
                	steps{
                	recordIssues(tools: [
                	    pmdParser(pattern: 'target/pmd.xml'),
                	    checkStyle(pattern: 'target/checkstyle.xml'),
                	    findBugs(pattern: 'target/findbugs.xml')])
                			}
                		}

		stage('Compile') {
        			steps{
        				sh 'mvn compile'
        			}
        		}

		stage('Test') {
			steps{
				sh 'mvn test'
			}
		}

		stage('Integration Test') {
			steps{
				sh 'mvn failsafe:integration-test failsafe:verify'
			}
		}

		stage('Package') {
			steps{
				sh 'mvn package -DskipTests'
			}
		}

        stage('Jacoco Code Coverage') {
        			steps{
                        junit '**/*.xml'
                        jacoco(execPattern:'target/jacoco.exec')
        			}
        		}

		/*stage('Build Docker Image') {
			steps{
				//docker build -t myjenkins/jenkinsmicroService:$env.BUILD_TAG
				script{
					dockerImage = docker.build("jenkinservice/jenkinsmicroservice:$env.BUILD_TAG")
				}
			}
		}

		stage('Push Docker Image') {
			steps{
				script{
                    docker.withRegistry('','dockerhub'){
					dockerImage.push();
					dockerImage.push('latest');
					}
				}
			}
		}*/
	} 
	
	post{
        always{
			echo 'I run always'
		}
		success{
			echo 'I run when you are success'
		}
		failure{
			echo 'I run when you fail'
		}
		//unstable: When the test failure happens
	}
}
