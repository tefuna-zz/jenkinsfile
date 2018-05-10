#!groovy

/**
 * gradleタスクでwarファイルを生成します。
 */
def call(target) {
    dir (target) { 
        sh 'chmod 744 gradlew && ./gradlew --info clean jar'
    }
}
