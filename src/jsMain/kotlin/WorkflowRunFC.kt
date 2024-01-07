import bootstrapFC.Card
import bootstrapFC.ReactCardProps
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
import react.dom.html.ReactHTML.p


external interface WorkflowRunsProps : Props {

    var workflowRun: WorkflowRun
    var onJobsFetch: () -> Unit

}

val WorkflowRunFC = FC<WorkflowRunsProps> { props ->

    Card {
        title = "test"
        children =

            p {
                ReactButton {
                    variant = "dark"
                    size = "sm"
                    +"Jobs"
                    onClick = { props.onJobsFetch() }

                }
                +props.workflowRun.headCommit.message
                br()
                +"Conclusion: ${props.workflowRun.conclusion}"
            }
    }

}


