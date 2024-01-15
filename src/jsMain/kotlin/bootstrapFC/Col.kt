
@file:JsModule("react-bootstrap/Col")
@file:JsNonModule

import react.*

external interface ColProps : Props {
    var className: String

    var xs: String
    var sm: String
    var md: String
    var lg: String
    var xl: String
    var xxl: String
}

@JsName("default")
external val Col: ComponentClass<ColProps>
