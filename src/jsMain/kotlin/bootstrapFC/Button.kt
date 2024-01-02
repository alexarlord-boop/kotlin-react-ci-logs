@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.ComponentClass
import react.Props

@JsName("Button")
external val ReactButton: ComponentClass<ReactButtonProps>

external interface ReactButtonProps : Props {
    var variant: String
    var size: String
    var onClick: () -> Unit
}

