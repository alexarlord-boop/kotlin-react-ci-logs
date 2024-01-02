@file:JsModule("react-player")
@file:JsNonModule

import react.*
external interface ReactPlayerProps : Props {
    var url: String
    var controls: Boolean
}

@JsName("default")
external val ReactPlayer: ComponentClass<ReactPlayerProps>

