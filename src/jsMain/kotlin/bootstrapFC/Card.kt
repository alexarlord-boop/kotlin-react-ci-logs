@file:JsModule("react-bootstrap")
@file:JsNonModule
package bootstrapFC


import react.ComponentClass
import react.Props
import react.FC

@JsName("Card")
external val Card: ComponentClass<ReactCardProps>

external interface ReactCardProps : Props {
    var variant: String? // Example: "primary", "secondary", etc.
    var size: String? // Example: "lg", "sm"
    var onClick: () -> Unit
    var title: String? // Example: "Card Title"
    var children: Unit? // Example: <p>Card content</p>
    // Add other properties based on the actual properties of the React Bootstrap Card component
}