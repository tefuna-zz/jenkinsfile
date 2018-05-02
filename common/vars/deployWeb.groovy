#!groovy

/**
 * Webアプリケーションをデプロイします。
 */
def call(APP_ID, ENVIRONMENT, ARTIFACTS_PATH, IS_DEPLOY) {
    if (currentBuild.currentResult == 'SUCCESS' && IS_DEPLOY == 'true') {
        echo "deployWeb ${ARTIFACTS_PATH}, ${APP_ID}, ${ENVIRONMENT}, ${IS_DEPLOY}"
    } else {
        echo "skip deploy. ${APP_ID}, ${ENVIRONMENT}, ${IS_DEPLOY}"
    }
}
