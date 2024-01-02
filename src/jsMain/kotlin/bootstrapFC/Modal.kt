@file:JsModule("react-bootstrap")
@file:JsNonModule
package bootstrapFC

import react.ComponentClass
import react.Props
import react.ReactElement

@JsName("Modal")
external val Modal: ComponentClass<ReactModalProps>

external interface ReactModalProps : Props {
    var show: Boolean
    var onHide: () -> Unit
    var size: String? // Adjust the size as needed (lg, sm, etc.)
}

external interface ModalHeaderProps : Props {
    var closeButton: Boolean?
}

@JsName("ModalHeader")
external val ModalHeader: ComponentClass<ModalHeaderProps>

@JsName("CloseButton")
external val CloseButton: ComponentClass<CloseButtonProps>

external interface CloseButtonProps : Props {
    var onClick: () -> Unit
    var variant: String? // Adjust the variant as needed (primary, secondary, etc.)
}

@JsName("ModalTitle")
external val ModalTitle: ComponentClass<Props>

@JsName("ModalBody")
external val ModalBody: ComponentClass<Props>

@JsName("ModalFooter")
external val ModalFooter: ComponentClass<Props>
