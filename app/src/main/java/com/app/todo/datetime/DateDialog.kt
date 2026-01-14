package com.app.todo.datetime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker

import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.app.todo.language.Language
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
  //  state: DatePickerState,
    modifier: Modifier = Modifier,
    onSelection: (String) -> Unit,
    onDismiss: () -> Unit,
    language: Language,
    dateFormat: String
) {
    val datePickerState = rememberDatePickerState()

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.secondary,
            tonalElevation = 10.dp
        ) {
            DatePicker(
                dateFormatter = DatePickerDefaults.dateFormatter(),
                title =
                    {
                        Text(
                            text = language.date_selection_dialog,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(10.dp)
                        )
                    },
                state = datePickerState,
                showModeToggle = false, // Cleaner look
                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    //containerColor = Color.Transparent, // Let Surface show through
                    titleContentColor = MaterialTheme.colorScheme.outline,
                    headlineContentColor = MaterialTheme.colorScheme.outline,
                    weekdayContentColor = MaterialTheme.colorScheme.outline,
                    navigationContentColor = MaterialTheme.colorScheme.outline,
                    dayContentColor = MaterialTheme.colorScheme.outline,
                    selectedDayContainerColor = MaterialTheme.colorScheme.tertiary,
                    selectedDayContentColor = MaterialTheme.colorScheme.secondary,
                    todayDateBorderColor = MaterialTheme.colorScheme.outline,
                    selectedYearContainerColor = MaterialTheme.colorScheme.tertiary,
                    yearContentColor = MaterialTheme.colorScheme.outline,
                    selectedYearContentColor = MaterialTheme.colorScheme.outline,
                ),

            )

            // 2. The Action Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = {
                    val date = datePickerState.selectedDateMillis
                    if (date != null) {
                        val localDate = millisToLocalDate(date)
                        val dateString = localDateToStandardFormatString(localDate)
                        onSelection(dateString)
                    }
                    onDismiss()
                }) {
                    Text("OK", color = MaterialTheme.colorScheme.outline,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }

}

@Composable
fun DateDialog(
    modifier: Modifier = Modifier,
    onSelection: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()


    DatePickerDialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(

        ),
        confirmButton = {
            TextButton(onClick = {
                val date = datePickerState.selectedDateMillis
                if (date != null) {
                    val localDate = millisToLocalDate(date)
                    val dateString = localDateToStandardFormatString(localDate)
                    onSelection(dateString)
                }
                onDismiss()
            }) { Text("OK",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.outline) }
        },
        /*
        colors = DatePickerDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondary,
            titleContentColor = MaterialTheme.colorScheme.outline,
            navigationContentColor = MaterialTheme.colorScheme.outline,
            dividerColor = MaterialTheme.colorScheme.outline,
            dayContentColor = MaterialTheme.colorScheme.outline,
            headlineContentColor = MaterialTheme.colorScheme.outline,
            subheadContentColor = MaterialTheme.colorScheme.outline
            )

         */
    ) {
        DatePicker(state = datePickerState)
    }

}