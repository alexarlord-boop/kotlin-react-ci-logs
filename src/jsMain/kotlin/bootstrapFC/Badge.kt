@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.ComponentClass
import react.Props

@JsName("Badge")
external val Badge: ComponentClass<BadgeProps>

external interface BadgeProps : Props {
    var bg: String
    var pill: Boolean
    var text: String
}

