#!groovy

/**
 * gradleタスクでwarファイルを生成します。
 */
def call(TARGET) {
    dir (TARGET) { 
        sh './gradlew --info clean war'
    }
}
