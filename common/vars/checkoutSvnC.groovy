#!groovy

/**
 * BtoC用SVNチェックアウトします。
 * チェックアウト先はjenkinsデフォルト（WORKSPACE環境変数）です。
 */
def call(REPOSITORY, BRANCH, TARGET) {
    def base = 'http://svn/svnlist';
    def path = "${base}/${REPOSITORY}/${BRANCH}/${TARGET}"
    checkout([$class: 'SubversionSCM', additionalCredentials: [[credentialsId: '0e196457-4953-45d1-b603-fc6403a37a11', realm: "<http://svn:80> Subversion repositories"]], excludedCommitMessages: '', excludedRegions: '', excludedRevprop: '', excludedUsers: '', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: '', locations: [[credentialsId: '', depthOption: 'infinity', ignoreExternalsOption: true, remote: "${path}"]], workspaceUpdater: [$class: 'CheckoutUpdater']])
}
