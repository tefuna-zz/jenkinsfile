#!groovy

/**
 * ビルド通知メッセージを送信します。
 */
def call(MESSAGE, ARTIFACTS) {
    def teamDomain = 'np-isid'
    def channel = '#jenkins'
    if (currentBuild.result == null) {
        color = '#439FE0'
        prefix = ':information_source:'
        postfix = ':pray:'
    } else if (currentBuild.result == 'SUCCESS') {
        color = 'good'
        prefix = ':ok:'
        postfix = ':ok_woman::confetti_ball::tada::tada::tada::innocent:'
    } else {
        color = 'danger'
        prefix = ':ng:'
        postfix = ':no_good::moyai::shit::shit::shit::moyai:'
    }

    def message = "${prefix}${MESSAGE}${postfix} \nJOB: ${env.JOB_BASE_NAME}\nBUILD_URL: ${env.BUILD_URL}"
    if (ARTIFACTS != null) {
        message <<= "\nARTIFACTS: ${ARTIFACTS}"
    }

    echo "${teamDomain}, ${channel}, ${color}, ${message}"
    slackSend teamDomain: teamDomain, channel: channel, color: color, message: message.toString()
}

/**
 * ビルド通知メッセージを送信します。
 */
def call(MESSAGE) {
    call(MESSAGE, null, null)
}
