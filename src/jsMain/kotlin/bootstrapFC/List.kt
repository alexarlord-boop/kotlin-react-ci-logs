@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.ComponentClass
import react.Props

@JsName("ListGroup")
external val ListGroup: ComponentClass<ListGroupProps>

external interface ListGroupProps : Props {
    var variant: String
    var horizontal: String
    var numbered: Boolean
}


@JsName("ListGroupItem")
external val ListGroupItem: ComponentClass<ListGroupItemProps>

external interface ListGroupItemProps : Props {
    var variant: String
    var action: Boolean
    var active: Boolean
    var disabled: Boolean
    var eventKey: String
    var onClick: () -> Unit

}