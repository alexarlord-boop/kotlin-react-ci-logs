// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json { allowStructuredMapKeys = true }
// val welcome = json.parse(Welcome.serializer(), jsonString)

package quicktype

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class WorkflowData (
    @SerialName("total_count")
    val totalCount: Long,

    @SerialName("workflow_runs")
    val workflowRuns: List<WorkflowRun>
)

@Serializable
data class WorkflowRun (
    val id: Long,
    val name: String,

    @SerialName("node_id")
    val nodeID: String,

    @SerialName("head_branch")
    val headBranch: HeadBranch,

    @SerialName("head_sha")
    val headSHA: String,

    val path: Path,

    @SerialName("display_title")
    val displayTitle: String,

    @SerialName("run_number")
    val runNumber: Long,

    val event: Event,
    val status: Status,
    val conclusion: Conclusion,

    @SerialName("workflow_id")
    val workflowID: Long,

    @SerialName("check_suite_id")
    val checkSuiteID: Long,

    @SerialName("check_suite_node_id")
    val checkSuiteNodeID: String,

    val url: String,

    @SerialName("html_url")
    val htmlURL: String,

    @SerialName("pull_requests")
    val pullRequests: List<PullRequest>,

    @SerialName("created_at")
    val createdAt: String,

    @SerialName("updated_at")
    val updatedAt: String,

    val actor: Actor,

    @SerialName("run_attempt")
    val runAttempt: Long,

    @SerialName("referenced_workflows")
    val referencedWorkflows: JsonArray,

    @SerialName("run_started_at")
    val runStartedAt: String,

    @SerialName("triggering_actor")
    val triggeringActor: Actor,

    @SerialName("jobs_url")
    val jobsURL: String,

    @SerialName("logs_url")
    val logsURL: String,

    @SerialName("check_suite_url")
    val checkSuiteURL: String,

    @SerialName("artifacts_url")
    val artifactsURL: String,

    @SerialName("cancel_url")
    val cancelURL: String,

    @SerialName("rerun_url")
    val rerunURL: String,

    @SerialName("previous_attempt_url")
    val previousAttemptURL: JsonElement? = null,

    @SerialName("workflow_url")
    val workflowURL: String,

    @SerialName("head_commit")
    val headCommit: HeadCommit,

    val repository: Repository,

    @SerialName("head_repository")
    val headRepository: Repository
)

@Serializable
data class Actor (
    val login: Login,
    val id: Long,

    @SerialName("node_id")
    val nodeID: ActorNodeID,

    @SerialName("avatar_url")
    val avatarURL: String,

    @SerialName("gravatar_id")
    val gravatarID: String,

    val url: String,

    @SerialName("html_url")
    val htmlURL: String,

    @SerialName("followers_url")
    val followersURL: String,

    @SerialName("following_url")
    val followingURL: String,

    @SerialName("gists_url")
    val gistsURL: String,

    @SerialName("starred_url")
    val starredURL: String,

    @SerialName("subscriptions_url")
    val subscriptionsURL: String,

    @SerialName("organizations_url")
    val organizationsURL: String,

    @SerialName("repos_url")
    val reposURL: String,

    @SerialName("events_url")
    val eventsURL: String,

    @SerialName("received_events_url")
    val receivedEventsURL: String,

    val type: Type,

    @SerialName("site_admin")
    val siteAdmin: Boolean
)

@Serializable
enum class Login(val value: String) {
    @SerialName("github-advanced-security[bot]") GithubAdvancedSecurityBot("github-advanced-security[bot]"),
    @SerialName("simplesamlphp") Simplesamlphp("simplesamlphp"),
    @SerialName("thijskh") Thijskh("thijskh"),
    @SerialName("tvdijen") Tvdijen("tvdijen");
}

@Serializable
enum class ActorNodeID(val value: String) {
    @SerialName("MDEyOk9yZ2FuaXphdGlvbjU3NzQ2NDA=") MDEyOk9YZ2FuaXphdGlvbjU3NzQ2NDA("MDEyOk9yZ2FuaXphdGlvbjU3NzQ2NDA="),
    @SerialName("MDM6Qm90NjIzMTA4MTU=") MDM6Qm90NjIzMTA4MTU("MDM6Qm90NjIzMTA4MTU="),
    @SerialName("MDQ6VXNlcjM4MDg3OTI=") MDQ6VXNlcjM4MDg3OTI("MDQ6VXNlcjM4MDg3OTI="),
    @SerialName("MDQ6VXNlcjg0MTA0NQ==") MDQ6VXNlcjg0MTA0NQ("MDQ6VXNlcjg0MTA0NQ==");
}

@Serializable
enum class Type(val value: String) {
    @SerialName("Bot") Bot("Bot"),
    @SerialName("Organization") Organization("Organization"),
    @SerialName("User") User("User");
}

@Serializable
enum class Conclusion(val value: String) {
    @SerialName("failure") Failure("failure"),
    @SerialName("success") Success("success");
}

@Serializable
enum class Event(val value: String) {
    @SerialName("dynamic") Dynamic("dynamic"),
    @SerialName("push") Push("push"),
    @SerialName("schedule") Schedule("schedule");
}

@Serializable
enum class HeadBranch(val value: String) {
    @SerialName("master") Master("master"),
    @SerialName("simplesamlphp-1.19") Simplesamlphp119("simplesamlphp-1.19"),
    @SerialName("simplesamlphp-2.0") Simplesamlphp20("simplesamlphp-2.0"),
    @SerialName("simplesamlphp-2.1") Simplesamlphp21("simplesamlphp-2.1"),
    @SerialName("simplesamlphp-2.2") Simplesamlphp22("simplesamlphp-2.2");
}

@Serializable
data class HeadCommit (
    val id: String,

    @SerialName("tree_id")
    val treeID: String,

    val message: String,
    val timestamp: String,
    val author: Author,
    val committer: Author
)

@Serializable
data class Author (
    val name: Name,
    val email: Email
)

@Serializable
enum class Email(val value: String) {
    @SerialName("mail@zipixx.com") MailZipixxCOM("mail@zipixx.com"),
    @SerialName("noreply@github.com") NoreplyGithubCOM("noreply@github.com"),
    @SerialName("41898282+github-actions[bot]@users.noreply.github.com") The41898282GithubActionsBotUsersNoreplyGithubCOM("41898282+github-actions[bot]@users.noreply.github.com"),
    @SerialName("thijs@kinkhorst.com") ThijsKinkhorstCOM("thijs@kinkhorst.com"),
    @SerialName("tvdijen@gmail.com") TvdijenGmailCOM("tvdijen@gmail.com");
}

@Serializable
enum class Name(val value: String) {
    @SerialName("GitHub") GitHub("GitHub"),
    @SerialName("github-actions") GithubActions("github-actions"),
    @SerialName("Stefan P") StefanP("Stefan P"),
    @SerialName("Thijs Kinkhorst") ThijsKinkhorst("Thijs Kinkhorst"),
    @SerialName("Tim van Dijen") TimVanDijen("Tim van Dijen");
}

@Serializable
data class Repository (
    val id: Long,

    @SerialName("node_id")
    val nodeID: HeadRepositoryNodeID,

    val name: Login,

    @SerialName("full_name")
    val fullName: FullName,

    val private: Boolean,
    val owner: Actor,

    @SerialName("html_url")
    val htmlURL: String,

    val description: String,
    val fork: Boolean,
    val url: String,

    @SerialName("forks_url")
    val forksURL: String,

    @SerialName("keys_url")
    val keysURL: String,

    @SerialName("collaborators_url")
    val collaboratorsURL: String,

    @SerialName("teams_url")
    val teamsURL: String,

    @SerialName("hooks_url")
    val hooksURL: String,

    @SerialName("issue_events_url")
    val issueEventsURL: String,

    @SerialName("events_url")
    val eventsURL: String,

    @SerialName("assignees_url")
    val assigneesURL: String,

    @SerialName("branches_url")
    val branchesURL: String,

    @SerialName("tags_url")
    val tagsURL: String,

    @SerialName("blobs_url")
    val blobsURL: String,

    @SerialName("git_tags_url")
    val gitTagsURL: String,

    @SerialName("git_refs_url")
    val gitRefsURL: String,

    @SerialName("trees_url")
    val treesURL: String,

    @SerialName("statuses_url")
    val statusesURL: String,

    @SerialName("languages_url")
    val languagesURL: String,

    @SerialName("stargazers_url")
    val stargazersURL: String,

    @SerialName("contributors_url")
    val contributorsURL: String,

    @SerialName("subscribers_url")
    val subscribersURL: String,

    @SerialName("subscription_url")
    val subscriptionURL: String,

    @SerialName("commits_url")
    val commitsURL: String,

    @SerialName("git_commits_url")
    val gitCommitsURL: String,

    @SerialName("comments_url")
    val commentsURL: String,

    @SerialName("issue_comment_url")
    val issueCommentURL: String,

    @SerialName("contents_url")
    val contentsURL: String,

    @SerialName("compare_url")
    val compareURL: String,

    @SerialName("merges_url")
    val mergesURL: String,

    @SerialName("archive_url")
    val archiveURL: String,

    @SerialName("downloads_url")
    val downloadsURL: String,

    @SerialName("issues_url")
    val issuesURL: String,

    @SerialName("pulls_url")
    val pullsURL: String,

    @SerialName("milestones_url")
    val milestonesURL: String,

    @SerialName("notifications_url")
    val notificationsURL: String,

    @SerialName("labels_url")
    val labelsURL: String,

    @SerialName("releases_url")
    val releasesURL: String,

    @SerialName("deployments_url")
    val deploymentsURL: String
)

@Serializable
enum class FullName(val value: String) {
    @SerialName("simplesamlphp/simplesamlphp") SimplesamlphpSimplesamlphp("simplesamlphp/simplesamlphp");
}

@Serializable
enum class HeadRepositoryNodeID(val value: String) {
    @SerialName("MDEwOlJlcG9zaXRvcnkxNzE2NzEzNg==") MDEwOlJlcG9ZaXRvcnkxNzE2NzEzNg("MDEwOlJlcG9zaXRvcnkxNzE2NzEzNg==");
}

@Serializable
enum class Path(val value: String) {
    @SerialName("dynamic/github-code-scanning/codeql") DynamicGithubCodeScanningCodeql("dynamic/github-code-scanning/codeql"),
    @SerialName(".github/workflows/autolock-conversations.yml") GithubWorkflowsAutolockConversationsYml(".github/workflows/autolock-conversations.yml"),
    @SerialName(".github/workflows/documentation.yml") GithubWorkflowsDocumentationYml(".github/workflows/documentation.yml"),
    @SerialName(".github/workflows/php.yml") GithubWorkflowsPHPYml(".github/workflows/php.yml"),
    @SerialName(".github/workflows/translations.yml") GithubWorkflowsTranslationsYml(".github/workflows/translations.yml");
}

@Serializable
data class PullRequest (
    val url: String,
    val id: Long,
    val number: Long,
    val head: Base,
    val base: Base
)

@Serializable
data class Base (
    val ref: HeadBranch,
    val sha: SHA,
    val repo: Repo
)

@Serializable
data class Repo (
    val id: Long,
    val url: String,
    val name: Login
)

@Serializable
enum class SHA(val value: String) {
    @SerialName("d4ce6b26b7aba3d31b6fdbf7f1d07b194a1b28f8") D4Ce6B26B7Aba3D31B6Fdbf7F1D07B194A1B28F8("d4ce6b26b7aba3d31b6fdbf7f1d07b194a1b28f8"),
    @SerialName("28bbae2dc5d272bda323f2728ee6c8828d75bc0e") The28Bbae2Dc5D272Bda323F2728Ee6C8828D75Bc0E("28bbae2dc5d272bda323f2728ee6c8828d75bc0e"),
    @SerialName("9ae476b514cb3312aa396463c2c058a5cd8dbcb5") The9Ae476B514Cb3312Aa396463C2C058A5Cd8Dbcb5("9ae476b514cb3312aa396463c2c058a5cd8dbcb5");
}

@Serializable
enum class Status(val value: String) {
    @SerialName("completed") Completed("completed");
}
