package com.app.todo.ui.entry

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.app.todo.datetime.CustomDatePicker
import com.app.todo.datetime.DateDialog
import com.app.todo.datetime.getStandardDate
import com.app.todo.datetime.getStandardTime
import com.app.todo.datetime.localDateToStandardFormatString
import com.app.todo.language.German
import com.app.todo.language.Language
import com.app.todo.ui.appbar.TopAppBar
import com.app.todo.ui.navigation.NavigationDestination
import java.time.LocalDate
import java.time.LocalTime

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
        innerPadding ->
        NewToDoField(modifier = Modifier.padding(innerPadding),
            language = German)
    }
}

@Composable
private fun NewToDoField(
    modifier: Modifier = Modifier,
    language: Language
) {
    var title by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("5") }
    var dateString by remember { mutableStateOf(getStandardDate()) }
    var timeString by remember { mutableStateOf(getStandardTime()) }

    var openDateDialog by remember { mutableStateOf(false) }
    var openTimeDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(start=30.dp, end=30.dp, top=120.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
        EntryField(
            value = title,
            label = language.title_entry_label,
            onValueChange = {
                new -> title = new
            }
        )
        EntryField(
            value = priority,
            label = language.priority_entry_label,
            onValueChange = {
                    new -> priority = checkPriorityEntry(new)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        EntryField(
            value = dateString,
            label = language.date_entry_label,
            onValueChange = {
                new -> dateString = new
            },
            enabled = false,
            onTap = {
                openDateDialog = true
            }
        )
        EntryField(
            value = timeString,
            label = language.time_entry_label,
            onValueChange = {
                new -> timeString = new
            },
            enabled = false,
            onTap = {
                openTimeDialog = true
            }
        )
    }

    if (openDateDialog) {
        CustomDatePicker(
            onDismiss = {
                openDateDialog = false
            },
            onSelection = {
                s -> dateString = s
            },
            language = German
        )
    }

}

private fun checkPriorityEntry(new: String): String {
    if (new.isNotBlank()) {
        if (new.toInt() > 5) {
            return "5"
        }
        else if (new.toInt() < 1) {
            return "1"
        }
        else {
            return new
        }
    } else {
        return new
    }
}

@Composable
private fun EntryField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    enabled: Boolean = true,
    onTap: () -> Unit = {}
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures {
                    onTap()
                }
            },
        value = value,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline
            )
        },
        onValueChange = { new -> onValueChange(new) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.outline,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            unfocusedTextColor = MaterialTheme.colorScheme.outline,
            focusedTextColor = MaterialTheme.colorScheme.outline,
            disabledTextColor = MaterialTheme.colorScheme.outline,
            disabledBorderColor = MaterialTheme.colorScheme.outline,
            disabledLabelColor = MaterialTheme.colorScheme.outline
        ),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        enabled = enabled
    )
}