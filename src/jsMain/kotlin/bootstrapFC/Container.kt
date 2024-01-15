@file:JsModule("react-bootstrap/Container")
@file:JsNonModule


import react.*

external interface ContainerProps : Props {
    var className: String
    var fluid: String

}

@JsName("default")
external val Container: ComponentClass<ContainerProps>
