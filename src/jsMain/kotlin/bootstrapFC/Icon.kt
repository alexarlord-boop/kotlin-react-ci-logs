@file:JsModule("react-bootstrap-icons")
@file:JsNonModule

package bootstrapFC

import react.*


@JsName("CheckCircleFill")
external val CheckCircleFillIcon: ComponentClass<IconProps>

@JsName("XCircleFill")
external val XCircleFill: ComponentClass<IconProps>


external interface IconProps : Props {
    var className: String

}

