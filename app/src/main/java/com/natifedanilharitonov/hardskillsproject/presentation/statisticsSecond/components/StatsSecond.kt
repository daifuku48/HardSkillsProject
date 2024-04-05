package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.rememberMarker
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberEndAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.CartesianChartHost
import com.patrykandpatrick.vico.compose.chart.layer.rememberColumnCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineSpec
import com.patrykandpatrick.vico.compose.chart.rememberCartesianChart
import com.patrykandpatrick.vico.compose.chart.zoom.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.component.rememberLineComponent
import com.patrykandpatrick.vico.compose.component.shape.shader.color
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.chart.layer.ColumnCartesianLayer
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.model.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.model.columnSeries
import com.patrykandpatrick.vico.core.model.lineSeries
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext

@Composable
fun StatsSecond(
    modelLines: PersistentList<Pair<Float, Float>>,
    modelColumns: PersistentList<Pair<Float, Float>>,
) {
    val modelProducer = remember { CartesianChartModelProducer.build() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            while (isActive) {
                modelProducer.tryRunTransaction {
                    columnSeries {
                        series(
                            modelColumns.map { it.first }.toPersistentList(),
                            modelColumns.map { it.second }.toPersistentList(),
                        )
                    }
                    lineSeries {
                        series(
                            modelLines.map { it.first }.toPersistentList(),
                            modelLines.map { it.second }.toPersistentList(),
                        )
                    }
                }
            }
        }
    }

    CartesianChartHost(
        chart =
            rememberCartesianChart(
                rememberColumnCartesianLayer(
                    columns =
                        columnChartColors.map { color ->
                            rememberLineComponent(
                                color = color,
                                thickness = 8.dp,
                                shape = Shapes.roundedCornerShape(40),
                            )
                        },
                    mergeMode = { ColumnCartesianLayer.MergeMode.Stacked },
                    verticalAxisPosition = AxisPosition.Vertical.Start,
                ),
                rememberLineCartesianLayer(
                    lines =
                        listOf(
                            rememberLineSpec(shader = DynamicShaders.color(Color.Red)),
                        ),
                    verticalAxisPosition = AxisPosition.Vertical.End,
                ),
                startAxis = rememberStartAxis(guideline = null),
                endAxis = rememberEndAxis(guideline = null),
                bottomAxis = rememberBottomAxis(),
            ),
        modelProducer = modelProducer,
        modifier = Modifier.fillMaxWidth(),
        marker = rememberMarker(),
        runInitialAnimation = false,
        zoomState = rememberVicoZoomState(zoomEnabled = false),
    )
}

private val color1 = Color(0xffa55a5a)
private val color2 = Color(0xffd3756b)
private val color3 = Color(0xfff09b7d)
private val columnChartColors = listOf(color1, color2, color3)
