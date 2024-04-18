package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.utils.Constants.AXIS_ITEM_COUNT
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MAX_X
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MAX_Y
import com.natifedanilharitonov.hardskillsproject.utils.Constants.MIN_X
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.CHART_TAG
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.CartesianChartHost
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.chart.layer.rememberLineSpec
import com.patrykandpatrick.vico.compose.chart.rememberCartesianChart
import com.patrykandpatrick.vico.compose.chart.zoom.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.component.shape.shader.color
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.values.AxisValueOverrider
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.model.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.model.lineSeries
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val MIN_Y_MAIN_CHART = 10f
private const val PERSISTENT_MARKER_X = 4f

@Composable
fun Stats(model: PersistentList<Pair<Float, Float>>) {
    val marker = rememberMarker()
    val modelProducer = remember { CartesianChartModelProducer.build() }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            modelProducer.tryRunTransaction {
                lineSeries {
                    series(
                        model.map { it.first }.toPersistentList(),
                        model.map { it.second }.toPersistentList(),
                    )
                }
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
                            MIN_Y_MAIN_CHART,
                            MAX_Y,
                        ),
                    lines =
                        listOf(
                            rememberLineSpec(
                                shader = DynamicShaders.color(Color.Black),
                                backgroundShader = null,
                            ),
                        ),
                ),
                startAxis =
                    rememberStartAxis(
                        tick = null,
                        axis = null,
                        itemPlacer = remember { AxisItemPlacer.Vertical.count(count = { AXIS_ITEM_COUNT }) },
                    ),
                persistentMarkers = mapOf(PERSISTENT_MARKER_X to marker),
            ),
        modelProducer = modelProducer,
        modifier =
            Modifier
                .height(400.dp)
                .testTag(CHART_TAG)
                .fillMaxWidth(),
        marker = marker,
        zoomState = rememberVicoZoomState(zoomEnabled = false),
    )
}
