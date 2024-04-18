package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.components

import android.graphics.PorterDuff
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MAX_X
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MAX_Y
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MIN_X
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MIN_Y
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.CHART_TAG
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.rememberAxisLabelComponent
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.CartesianChartHost
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineSpec
import com.patrykandpatrick.vico.compose.chart.layout.fullWidth
import com.patrykandpatrick.vico.compose.chart.rememberCartesianChart
import com.patrykandpatrick.vico.compose.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.component.rememberShapeComponent
import com.patrykandpatrick.vico.compose.component.shape.dashedShape
import com.patrykandpatrick.vico.compose.component.shape.shader.color
import com.patrykandpatrick.vico.compose.component.shape.shader.fromComponent
import com.patrykandpatrick.vico.compose.component.shape.shader.verticalGradient
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.chart.values.AxisValueOverrider
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.component.shape.shader.TopBottomShader
import com.patrykandpatrick.vico.core.model.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.model.lineSeries
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val AXIS_ITEM_COUNT_FIRST_CHART = 11

@Composable
fun StatChartFirst(
    model: PersistentList<Pair<Float, Float>>,
    getStats: () -> Unit,
) {
    val modelProducer = remember { CartesianChartModelProducer.build() }
    LaunchedEffect(model) {
        withContext(Dispatchers.Default) {
            while (true) {
                modelProducer.tryRunTransaction {
                    lineSeries {
                        series(
                            x = model.map { it.first }.toPersistentList(),
                            y = model.map { it.second }.toPersistentList(),
                        )
                    }
                }
                delay(3000L)
                getStats()
            }
        }
    }

    CartesianChartHost(
        chart =
            rememberCartesianChart(
                rememberLineCartesianLayer(
                    axisValueOverrider =
                        AxisValueOverrider.fixed(
                            MIN_X,
                            MAX_X,
                            MIN_Y,
                            MAX_Y,
                        ),
                    lines =
                        listOf(
                            rememberLineSpec(
                                shader =
                                    TopBottomShader(
                                        DynamicShaders.color(Color.Cyan),
                                        DynamicShaders.color(Color.Green),
                                    ),
                                backgroundShader =
                                    TopBottomShader(
                                        DynamicShaders.composeShader(
                                            DynamicShaders.fromComponent(
                                                componentSize = 6.dp,
                                                component =
                                                    rememberShapeComponent(
                                                        shape = Shapes.pillShape,
                                                        color = Color.Cyan,
                                                        margins = remember { dimensionsOf(1.dp) },
                                                    ),
                                            ),
                                            DynamicShaders.verticalGradient(
                                                arrayOf(Color.Black, Color.Transparent),
                                            ),
                                            PorterDuff.Mode.DARKEN,
                                        ),
                                        DynamicShaders.composeShader(
                                            DynamicShaders.fromComponent(
                                                componentSize = 5.dp,
                                                component =
                                                    rememberShapeComponent(
                                                        shape = Shapes.rectShape,
                                                        color = Color.Green,
                                                        margins = remember { dimensionsOf(horizontal = 2.dp) },
                                                    ),
                                                checkeredArrangement = false,
                                            ),
                                            DynamicShaders.verticalGradient(
                                                arrayOf(Color.Transparent, Color.Black),
                                            ),
                                            PorterDuff.Mode.DARKEN,
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
                        itemPlacer = remember { AxisItemPlacer.Vertical.count(count = { AXIS_ITEM_COUNT_FIRST_CHART }) },
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
        modifier =
            Modifier
                .fillMaxWidth()
                .testTag(CHART_TAG),
        runInitialAnimation = false,
        horizontalLayout = HorizontalLayout.fullWidth(),
    )
}
