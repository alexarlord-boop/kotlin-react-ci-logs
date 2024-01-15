@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.ComponentClass
import react.Props

external interface TabsProps : Props {
    var activeKey: String?
    var defaultActiveKey: String?
    var variant: String?
    var transition: dynamic // You may need to refine the type based on actual usage
    var id: String?
    var onSelect: (eventKey: Any, event: dynamic) -> Unit
    var mountOnEnter: Boolean?
    var unmountOnExit: Boolean?
    var fill: Boolean?
    var justify: Boolean?
}

external interface TabProps : Props {
    var eventKey: Any?
   var title: String
}

@JsName("Tabs")
external val Tabs: ComponentClass<TabsProps>

@JsName("Tab")
external val Tab: ComponentClass<TabProps>


external interface TabContainerProps : Props {
    var id: String?
    var defaultActiveKey: String?
    var transition: dynamic // You may need to refine the type based on actual usage
    var mountOnEnter: Boolean?
    var unmountOnExit: Boolean?
    var generateChildId: (eventKey: Any, type: String) -> String
    var onSelect: (eventKey: Any, event: dynamic) -> Unit
    var activeKey: String?
}

@JsName("TabContainer")
external val TabContainer: ComponentClass<TabContainerProps>



@JsName("TabContent")
external val TabContent: ComponentClass<Props>

external interface TabPaneProps : Props {
    var bsPrefix: String?
    var eventKey: Any?
    var active: Boolean?
    var transition: dynamic // You may need to refine the type based on actual usage
    var onEnter: () -> Unit
    var onEntering: () -> Unit
    var onEntered: () -> Unit
    var onExit: () -> Unit
    var onExiting: () -> Unit
    var onExited: () -> Unit
    var mountOnEnter: Boolean?
    var unmountOnExit: Boolean?
    var id: String?
    var ariaLabelledBy: String?
}

@JsName("TabPane")
external val TabPane: ComponentClass<TabPaneProps>
