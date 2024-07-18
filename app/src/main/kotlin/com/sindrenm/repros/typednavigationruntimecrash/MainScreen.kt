package com.sindrenm.repros.typednavigationruntimecrash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sindrenm.repros.typednavigationruntimecrash.feature1.FeatureGraphRoute
import com.sindrenm.repros.typednavigationruntimecrash.feature1.FeatureHomeRoute
import com.sindrenm.repros.typednavigationruntimecrash.feature1.featureNavGraph
import kotlinx.serialization.Serializable

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = HomeRoute, modifier.fillMaxSize()) {
        homeScreen(navController)

        featureNavGraph()
    }
}

@Serializable
data object HomeRoute

private fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable<HomeRoute> {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Home Screen")

            OutlinedButton(
                onClick = {
                    // Navigating to FeatureGraphRoute instead will fix the crash
                    // when building the graph, since R8 will not remove it.
//                    navController.navigate(FeatureGraphRoute)
                    navController.navigate(FeatureHomeRoute)
                }
            ) {
                Text("Go to Feature Home")
            }
        }
    }
}
