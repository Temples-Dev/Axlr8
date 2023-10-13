package temples.dev.presentation.screen

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class BackgroundSquareShapeWithLeftBottomCurved(private val curveRadius: Float) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            val topLeft = Offset(0f, 0f)
            val topRight = Offset(size.width, 0f)
            val bottomRight = Offset(size.width, size.height)
//               val bottomLeft = Offset(0f, size.height)

            moveTo(topLeft.x, topLeft.y)
            lineTo(topRight.x, topRight.y)
            lineTo(bottomRight.x, bottomRight.y)
//               lineTo(bottomLeft.x, bottomLeft.y)


            arcTo(
                rect = Rect(
                    left = 0f,
                    top = size.height - 2 * curveRadius,
                    right = 2 * curveRadius,
                    bottom = size.height
                ), startAngleDegrees = 90f, sweepAngleDegrees = 90f, forceMoveTo = false
            )

            close()

        })
    }
}