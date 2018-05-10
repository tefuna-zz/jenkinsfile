#!groovy

/**
 * checkout from github.
 *
 * @param repository
 * @param branch
 */
def call(target, branch = 'master') {
    def _path = 'https://github.com/tefuna/' + ${target} + '.git'
    def _credentialsId = 'github'
    def _changelog = false
    def _poll = false
    dir (target) {
        git url: ${_path}, branch: ${branch}, credentialsId: ${_credentialsId}, changelog: ${_changelog},  poll: ${_poll}
    }
}
