package com.sindrenm.repros.typednavigationruntimecrash.feature1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable

@Serializable
data object FeatureGraphRoute

@Serializable
data object FeatureHomeRoute

fun NavGraphBuilder.featureNavGraph() {
    navigation<FeatureGraphRoute>(startDestination = FeatureHomeRoute) {
        featureHomeScreen()
    }
}

private fun NavGraphBuilder.featureHomeScreen() {
    composable<FeatureHomeRoute> {
        Box(Modifier.fillMaxSize()) {
            Text(
                text = "Feature Home Screen",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
