
@file:JsModule("react-bootstrap/Row")
@file:JsNonModule

import react.*

external interface RowProps : Props {
    var className: String
    var xs: String
    var sm: String
    var md: String
    var lg: String
    var xl: String
    var xxl: String
}

@JsName("default")
external val Row: ComponentClass<RowProps>
