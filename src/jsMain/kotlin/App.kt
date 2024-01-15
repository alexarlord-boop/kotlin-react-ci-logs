import bootstrapFC.*
import csstype.*
import react.*
import kotlinx.coroutines.*
import emotion.react.css

import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.h2

val mainScope = MainScope()


val App = FC<Props> {


    // JB intern improved web app

    var publicRepo: String by useState("https://github.com/simplesamlphp/simplesamlphp")
    var workflowList: List<WorkflowRun> by useState(emptyList())

    input {
        css {
            width = 400.px
        }
        placeholder = "public repo url"
        value = publicRepo
        onChange = { nv ->
            publicRepo = nv.target.value
        }
    }

    var isLoading by useState(false)


    ReactButton {
        variant = "primary"
        size = "md"
        if (isLoading) {
            // Show loading indicator
            +"Loading..."
        } else {
            // Show regular button text
            +"Get workflows"
        }

        onClick = {
            isLoading = true // Set loading to true when the coroutine starts

            mainScope.launch {
                try {
                    val (owner, name) = publicRepo.split(".com/")[1].split("/")
                    workflowList = fetchWorkflows(owner, name).workflowRuns
                } finally {
                    isLoading = false // Set loading to false when the coroutine finishes
                }
            }
        }
    }

    var jobsModalShown by useState(false)
    val closeModal = { jobsModalShown = false }
    var isLoadingJobs by useState(false)

    // WORKFLOW LIST
    var jobsContent by useState("no jobs fetched")


    WorkflowArea {
        workflows = workflowList
        onJobsFetchFunction = { workflow ->
            isLoadingJobs = true
            jobsModalShown = true
            jobsContent = ""
            mainScope.launch {
                try {
                    jobsContent = fetchJobs(workflow.jobsURL)
                } finally {
                    isLoadingJobs = false
                }
            }
        }
    }


    // MODAL WINDOW: WORKFLOW JOBS INFO
    Modal {
        show = jobsModalShown
        onHide = closeModal
        size = "lg"

        ModalHeader {
            closeButton = true

            ModalTitle {
                +"Modal Title"
            }
        }

        ModalBody {
            if (isLoadingJobs) {
                +"Loading..."
            } else {
                p {
                    +jobsContent
                }
            }
        }

        ModalFooter {
            ReactButton {
                +"close"
                onClick = closeModal
            }
        }
    }


}

