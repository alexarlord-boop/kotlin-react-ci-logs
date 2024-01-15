import csstype.*
import emotion.react.css
import react.*
import react.dom.*
import react.dom.html.ReactHTML.h4
import emotion.react.Global
import emotion.react.styles
import react.dom.html.ReactHTML.div

external interface WorkflowAreaProps : Props {
    var workflows: List<WorkflowRun>
    var onJobsFetchFunction: (workflow: WorkflowRun) -> Unit
}


val WorkflowArea = FC<WorkflowAreaProps> { props ->
    Container {
        fluid = "xl"
        className = "mt-5"


        Tabs {
            id = "workflowTabs"

            useEffect(props.workflows) {
                defaultActiveKey = if (props.workflows.isNotEmpty()) {
                    props.workflows.groupBy { it.name }.keys.first()
                } else {
                    // Set a default key when workflows are empty
                    "defaultKey"
                }
            }

            fill = true

            props.workflows.groupBy { it.name } // Group workflows by name
                .forEach { (name, workflowsByName) ->

                    Tab {
                        eventKey = name
                        title = name
                        Col {
                            xs = "12"
                            sm = "12"
                            md = "6"
                            lg = "6"
                            xl = "6"
                            xxl = "6"

                            // Named section
                            className = "my-4 px-2 "
                            h4 {
                                Badge {
                                    pill = true
                                    bg = "primary"
                                    +name
                                }
                            }

                            // Display workflows in the group
                            Accordion {

                                div {
                                    css {
                                        maxHeight = 400.px
                                        overflowY = Overflow.scroll
                                        borderBottom = 1.px
                                        position = Position.relative
                                    }

                                    workflowsByName.forEach { workflow ->
                                        // Render WorkflowRunFC for each workflow in the group
                                        WorkflowRunFC {
                                            id = workflowsByName.indexOf(workflow)
                                            workflowRun = workflow
                                            onJobsFetch = { props.onJobsFetchFunction(workflow) }
                                        }
                                    }

                                    // Add a div with gradient at the bottom (overlay)
                                    if (workflowsByName.size > 5) {
                                        div {
                                            css {
                                                position = Position.sticky
                                                bottom = 0.px
                                                left = 0.px
                                                right = 0.px
                                                height = 10.px // Adjust the height of the gradient as needed
                                                backgroundImage = linearGradient(
                                                    0.deg,
                                                    rgba(51, 51, 51, 0.3),
                                                    rgba(204, 204, 204, 0.3)
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }

                }
        }


    }

}