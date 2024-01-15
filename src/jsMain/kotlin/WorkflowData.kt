// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json { allowStructuredMapKeys = true }
// val welcome = json.parse(Welcome.serializer(), jsonString)

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
    val headBranch: String,

    @SerialName("head_sha")
    val headSHA: String,

    val path: String,

    @SerialName("display_title")
    val displayTitle: String,

    @SerialName("run_number")
    val runNumber: Long,

    val event: String,
    val status: String,
    val conclusion: String,

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
    val login: String,
    val id: Long,

    @SerialName("node_id")
    val nodeID: String,

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

    val type: String,

    @SerialName("site_admin")
    val siteAdmin: Boolean
)


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
    val name: String,
    val email: String
)



@Serializable
data class Repository (
    val id: Long,

    @SerialName("node_id")
    val nodeID: String,

    val name: String,

    @SerialName("full_name")
    val fullName: String,

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
data class PullRequest (
    val url: String,
    val id: Long,
    val number: Long,
    val head: Base,
    val base: Base
)

@Serializable
data class Base (
    val ref: String,
    val sha: String,
    val repo: Repo
)

@Serializable
data class Repo (
    val id: Long,
    val url: String,
    val name: String
)

