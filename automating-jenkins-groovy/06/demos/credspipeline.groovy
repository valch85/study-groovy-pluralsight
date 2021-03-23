node{
    stage('Github'){
        git credentialsId: 'githubcreds', url: 'https://github.com/FeynmanFan/needscredentials.git'
    }
}