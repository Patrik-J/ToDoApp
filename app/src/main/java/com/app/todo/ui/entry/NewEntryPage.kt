package com.app.todo.ui.entry

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.todo.ui.appbar.TopAppBar
import com.app.todo.ui.navigation.NavigationDestination

object NewEntryDestination: NavigationDestination {
    override val route = "newentry"
}

@Composable
fun NewEntryPage(modifier: Modifier = Modifier,
                 onBack: () -> Unit) {

    BackHandler(
        enabled = true,
        onBack = {
            onBack()
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = "New Entry",
                onClick = {
                    onBack()
                },
                icon = Icons.AutoMirrored.Filled.ArrowBack
            )
        }
    ) {
        NewEntryField()
    }
}

@Composable
private fun NewEntryField(
    modifier: Modifier = Modifier
) {

}