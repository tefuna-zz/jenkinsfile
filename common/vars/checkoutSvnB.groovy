#!groovy

/**
 * BtoB用SVNチェックアウトします。
 * チェックアウト先はjenkinsデフォルト（WORKSPACE環境変数）です。
 */
def call(REPOSITORY, BRANCH, TARGET) {
    def base = 'http://svn/btob'
    def credentialsId = '2027b02e-88db-499d-bc5e-1c10dd058ed2'
    def path = "${base}/${REPOSITORY}/${BRANCH}/${TARGET}"
    checkout([$class: 'SubversionSCM', additionalCredentials: [[credentialsId: "${credentialsId}", realm: "<http://svn:80> Subversion repositories"]], excludedCommitMessages: '', excludedRegions: '', excludedRevprop: '', excludedUsers: '', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: '', locations: [[credentialsId: '', depthOption: 'infinity', ignoreExternalsOption: true, remote: "${path}"]], workspaceUpdater: [$class: 'CheckoutUpdater']])
}
