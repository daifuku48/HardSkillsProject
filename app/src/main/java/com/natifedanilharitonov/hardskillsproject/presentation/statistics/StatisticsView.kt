package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import android.graphics.PorterDuff
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.rememberAxisLabelComponent
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.CartesianChartHost
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineSpec
import com.patrykandpatrick.vico.compose.chart.layout.fullWidth
import com.patrykandpatrick.vico.compose.chart.rememberCartesianChart
import com.patrykandpatrick.vico.compose.component.marker.rememberMarkerComponent
import com.patrykandpatrick.vico.compose.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.component.rememberShapeComponent
import com.patrykandpatrick.vico.compose.component.shape.dashedShape
import com.patrykandpatrick.vico.compose.component.shape.shader.color
import com.patrykandpatrick.vico.compose.component.shape.shader.fromComponent
import com.patrykandpatrick.vico.compose.component.shape.shader.verticalGradient
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.component.marker.MarkerComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.component.shape.shader.TopBottomShader
import com.patrykandpatrick.vico.core.marker.DefaultMarkerLabelFormatter
import com.patrykandpatrick.vico.core.model.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.model.lineSeries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import kotlin.random.Random

@Composable
fun StatisticsView(viewModel: StatisticsViewModelImpl = koinViewModel()) {

}

private val chartColors
    @ReadOnlyComposable
    @Composable
    get() =
        listOf(
            colorResource(id = R.color.blue),
            colorResource(id = R.color.red),
        )

private val x = (1..100).toList()

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewChart() {
    val modelProducer = remember { CartesianChartModelProducer.build() }
    val colors = chartColors
    val label = rememberAxisLabelComponent(
        color = MaterialTheme.colorScheme.onBackground,
        background = rememberShapeComponent(
            shape = Shapes.pillShape,
            color = Color.Transparent,
            strokeColor = MaterialTheme.colorScheme.outlineVariant,
            strokeWidth = 1.dp,
        ),
        padding = remember { dimensionsOf(horizontal = 6.dp, vertical = 2.dp) },
        margins = remember { dimensionsOf(end = 8.dp) },
    )

    val marker = rememberMarkerComponent(
        label = label,
        labelFormatter = remember { DefaultMarkerLabelFormatter() },
        labelPosition = MarkerComponent.LabelPosition.Top,
        indicator = null,
        guideline = null
    )

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            while (isActive) {
                modelProducer.tryRunTransaction {
                    lineSeries {
                        series(
                            x = x,
                            y = x.map { Random.nextFloat() * 30 - 10 },
                        )
                    }
                }
                delay(500)
            }
        }
    }

    CartesianChartHost(
        chart =
        rememberCartesianChart(
            rememberLineCartesianLayer(
                lines =
                listOf(
                    rememberLineSpec(
                        shader =
                        TopBottomShader(
                            DynamicShaders.color(colors[0]),
                            DynamicShaders.color(colors[1]),
                        ),
                        backgroundShader =
                        TopBottomShader(
                            DynamicShaders.composeShader(
                                DynamicShaders.fromComponent(
                                    componentSize = 6.dp,
                                    component =
                                    rememberShapeComponent(
                                        shape = Shapes.pillShape,
                                        color = colors[0],
                                        margins = remember { dimensionsOf(1.dp) },
                                    ),
                                ),
                                DynamicShaders.verticalGradient(
                                    arrayOf(Color.Black, Color.Transparent),
                                ),
                                PorterDuff.Mode.DST_IN,
                            ),
                            DynamicShaders.composeShader(
                                DynamicShaders.fromComponent(
                                    componentSize = 5.dp,
                                    component =
                                    rememberShapeComponent(
                                        shape = Shapes.rectShape,
                                        color = colors[1],
                                        margins = remember { dimensionsOf(horizontal = 2.dp) },
                                    ),
                                    checkeredArrangement = false,
                                ),
                                DynamicShaders.verticalGradient(
                                    arrayOf(Color.Transparent, Color.Black),
                                ),
                                PorterDuff.Mode.DST_IN,
                            ),
                        ),
                    ),
                ),
            ),
            startAxis =
            rememberStartAxis(
                label =
                rememberAxisLabelComponent(
                    color = MaterialTheme.colorScheme.onBackground,
                    background =
                    rememberShapeComponent(
                        shape = Shapes.pillShape,
                        color = Color.Transparent,
                        strokeColor = MaterialTheme.colorScheme.outlineVariant,
                        strokeWidth = 1.dp,
                    ),
                    padding = remember { dimensionsOf(horizontal = 6.dp, vertical = 2.dp) },
                    margins = remember { dimensionsOf(end = 8.dp) },
                ),
                axis = null,
                tick = null,
                guideline =
                rememberLineComponent(
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape =
                    remember {
                        Shapes.dashedShape(
                            shape = Shapes.pillShape,
                            dashLength = 4.dp,
                            gapLength = 8.dp,
                        )
                    },
                ),
                itemPlacer = remember { AxisItemPlacer.Vertical.count(count = { 4 }) },
            ),
            bottomAxis =
            rememberBottomAxis(
                guideline = null,
                itemPlacer =
                remember {
                    AxisItemPlacer.Horizontal.default(
                        spacing = 3,
                        addExtremeLabelPadding = true,
                    )
                },
            ),
        ),
        modelProducer = modelProducer,
        modifier = Modifier.fillMaxWidth(),
        marker = marker,
        runInitialAnimation = false,
        horizontalLayout = HorizontalLayout.fullWidth(),
    )
}