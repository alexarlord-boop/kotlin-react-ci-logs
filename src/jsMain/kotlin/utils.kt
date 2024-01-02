import kotlinx.browser.window
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import quicktype.WorkflowData

suspend fun fetchVideo(id: Int): Video {
    val response = window
        .fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        .await()
        .text()
        .await()
    return Json.decodeFromString(response)
}

suspend fun fetchVideos(): List<Video> = coroutineScope {
    (1..25).map { id ->
        async {
            fetchVideo(id)
        }
    }.awaitAll()
}

suspend fun fetchWorkflows(repoOwner: String, repoName: String): WorkflowData {
    val response = window
        .fetch("https://api.github.com/repos/$repoOwner/$repoName/actions/runs")
        .await()
        .text()
        .await()

//    console.log("GitHub API Response:", response)

//    return response
    return Json.decodeFromString(response)
}

suspend fun fetchJobs(jobsUrl: String): String {
    val response = window
        .fetch(jobsUrl)
        .await()
        .text()
        .await()

    return response
}