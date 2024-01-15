import bootstrapFC.*
import csstype.*
import react.*
import emotion.react.css
import emotion.css.css
import react.*
import react.dom.*
import emotion.react.css
import kotlinx.coroutines.launch
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.ComponentClass
import react.Props
import react.dom.html.ReactHTML.h4
import react.dom.html.ReactHTML.h6
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span


external interface WorkflowRunsProps : Props {
    var id: Int
    var workflowRun: WorkflowRun
    var onJobsFetch: () -> Unit

}

val WorkflowRunFC = FC<WorkflowRunsProps> { props ->
    AccordionItem {
        eventKey = props.id.toString()
        div {
            AccordionHeader {
                Col {
                    Row {

                        Col {
                            if (props.workflowRun.conclusion == "success") CheckCircleFillIcon {
                                className = "text-success me-2"
                            } else XCircleFill { className = "d-inline text-danger me-2" }

                            val msg = props.workflowRun.headCommit.message

                            +msg
                        }

                    }
                    Row {
                        Col {
                            className = "text-secondary fs-6 ms-4"
                            val dateParts = props.workflowRun.createdAt
                            val date = js("new Date(dateParts)")
                            val dateOptions = js("{ year: 'numeric', month: 'short', day: 'numeric' }")
                            val timeOptions = js("{ hour: '2-digit', minute: '2-digit', hour12: true }")

                            val formattedDate = js("date.toLocaleDateString('en-US', dateOptions)")
                            val formattedTime = js("date.toLocaleTimeString('en-US', timeOptions)")

                            val formattedDateTime = "$formattedDate at $formattedTime"

                            +formattedDateTime
                        }
                    }
                }
            }
            AccordionBody {
                ReactButton {
                    variant = "dark"
                    size = "sm"
                    +"Jobs"
                    onClick = { props.onJobsFetch() }
                }
                +" -- click to fetch workflow jobs"
            }
        }
    }

}


