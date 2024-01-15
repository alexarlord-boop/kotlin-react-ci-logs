@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.ComponentClass
import react.Props


external interface AccordionProps : Props {
    var className: String
    var defaultActiveKey: String
}external interface AccordionItemProps : Props {
    var eventKey: String
}

@JsName("Accordion")
external val Accordion: ComponentClass<AccordionProps>

@JsName("AccordionItem")
external val AccordionItem: ComponentClass<AccordionItemProps>

@JsName("AccordionHeader")
external val AccordionHeader: ComponentClass<Props>

@JsName("AccordionBody")
external val AccordionBody: ComponentClass<Props>

@JsName("AccordionButton")
external val AccordionButton: ComponentClass<Props>

@JsName("AccordionCollapse")
external val AccordionCollapse: ComponentClass<Props>

@JsName("useAccordionButton")
external val useAccordionButton: () -> Unit
