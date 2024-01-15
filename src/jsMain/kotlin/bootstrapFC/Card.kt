@file:JsModule("react-bootstrap")
@file:JsNonModule
package bootstrapFC

import react.ComponentClass
import react.Props
import react.FC

external interface ReactCardProps : Props {
    var variant: String? // Example: "primary", "secondary", etc.
    var size: String? // Example: "lg", "sm"
    var onClick: () -> Unit
    var title: String? // Example: "Card Title"
    var children: Unit? // Example: <p>Card content</p>
    // Add other properties based on the actual properties of the React Bootstrap Card component
}

external interface SubComponentProps: Props {
    var className: String
}

@JsName("Card")
external val Card: ComponentClass<ReactCardProps>

@JsName("CardBody")
external val CardBody: FC<SubComponentProps>

@JsName("CardFooter")
external val CardFooter: FC<Props>

@JsName("CardHeader")
external val CardHeader: FC<Props>

@JsName("CardImg")
external val CardImg: FC<Props>

@JsName("CardImgOverlay")
external val CardImgOverlay: FC<Props>

@JsName("CardLink")
external val CardLink: FC<Props>

@JsName("CardSubtitle")
external val CardSubtitle: FC<Props>

@JsName("CardText")
external val CardText: FC<SubComponentProps>

@JsName("CardTitle")
external val CardTitle: FC<Props>

@JsName("CardGroup")
external val CardGroup: FC<Props>
