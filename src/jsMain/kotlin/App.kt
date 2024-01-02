import bootstrapFC.*
import csstype.*
import react.*
import kotlinx.coroutines.*
import emotion.react.css
import quicktype.WorkflowRun
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

    div {
        workflowList
            .groupBy { it.name } // Group workflows by name
            .forEach { (name, workflows) ->
                // Render a div for each group
                div {
                    h2 {
                        // Display the name of the group (workflow name)
                        +name
                    }
                    workflows.forEach { workflow ->
                        // Render WorkflowRunFC for each workflow in the group
                        WorkflowRunFC {
                            workflowRun = workflow
                            onJobsFetch = {
                                isLoadingJobs = true
                                jobsModalShown = true
                                jobsContent = ""


                                mainScope.launch {
                                    try {
                                        // Fetch jobs
                                        jobsContent = fetchJobs(workflow.jobsURL)
                                    } finally {
                                        // Set loading to false when the asynchronous operation completes
                                        isLoadingJobs = false
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    // MODAL WINDOW

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
                // Show loading indicator (e.g., skeleton or spinner)
                +"Loading..."
            } else {
                // Show the fetched content
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

