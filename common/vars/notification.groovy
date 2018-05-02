#!groovy

/**
 * 通知メッセージを送信します。
 */
def call(MESSAGE) {
    def teamDomain = 'np-isid'
    def channel = '#jenkins'
    def color = ''
    if (currentBuild.result == null) {
        color = '#439FE0'
    } else if (currentBuild.result == 'SUCCESS') {
        color = 'good'
    } else {
        color = 'danger'
    }

    slackSend teamDomain: teamDomain, channel: channel, color: color, message: MESSAGE
}
