#!groovy

/**
 * gradleタスクでリリース用のzipを生成します。
 * 事前にwarファイルが生成されている必要があります。
 * environment: ${ARTIFACTS_PATH} の事前定義は必須です。
 */
def call(TARGET, APP_ID, ENVIRONMENT, ARTIFACTS_PATH) {
    // gradle archive.
    dir (TARGET) { 
        sh "./gradlew --info -Penv=${ENVIRONMENT} archive"
    }

    // save artifact.
    def targetDir = "${env.WORKSPACE}/" + TARGET.replaceAll(/-master/,'') + "/target"
    echo targetDir
    dir (targetDir) { 
        sh "mkdir -p ${ARTIFACTS_PATH}/${APP_ID}/${ENVIRONMENT}"
        sh "cp -r ./${ENVIRONMENT} ${ARTIFACTS_PATH}/${APP_ID}"
        sh "cp -r ./${APP_ID}_${ENVIRONMENT}.zip ${ARTIFACTS_PATH}/${APP_ID}"
        archiveArtifacts "${APP_ID}_${ENVIRONMENT}.zip"
    }
}
