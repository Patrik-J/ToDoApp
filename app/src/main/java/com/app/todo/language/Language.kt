package com.app.todo.language

interface Language {
    // page titles
    val app_title: String
    val settings_page_title: String
    val new_todo_title: String
    val old_todo_title: String
    val edit_todo_title: String

    // buttons
    val create_entry_button: String
    val update_entry_button: String
    val new_todo_menu_button: String
    val old_todos_menu_button: String
    val calendar_menu_button: String
    val language_selection_button: String
    val darkmode_button: String
    val lightmode_button: String


    // messages
    val no_open_entries_msg: String
    val no_closed_entries_msg: String

    // error messages
    val new_entry_error_msg: String
    val new_entry_error_description_msg: String

    // textfields
    val title_entry_label: String
    val priority_entry_label: String
    val date_entry_label: String
    val time_entry_label: String

    // notifications
    val channel_name_notify: String
    val channel_description_notify: String

    // entry card
    val finishedOn: String

    val date_selection_dialog: String

}

object German: Language {
    override val app_title = "Dein ToDo Organizer"
    override val settings_page_title = "App Einstellung"
    override val new_todo_title = "Neues ToDo"
    override val old_todo_title = "Erledigte ToDo's"
    override val edit_todo_title = "ToDo Bearbeiten"
    override val create_entry_button = "Neu"
    override val update_entry_button = "Bestätigen"
    override val new_todo_menu_button = "Neues ToDo"
    override val old_todos_menu_button = "Erledigte ToDo's"
    override val calendar_menu_button = "Kalendar"
    override val language_selection_button = "Sprache"
    override val no_open_entries_msg = "Keine offenen ToDo's vorhanden :D"
    override val no_closed_entries_msg = "Keine erledigten Einträge vorhanden :P"
    override val new_entry_error_msg = "Fehler beim Erstellen des ToDo!"
    override val new_entry_error_description_msg = "Bitte überprüfe deine Eingaben."
    override val title_entry_label = "Titel"
    override val priority_entry_label = "Priorität (1-5)"
    override val date_entry_label = "Fristdatum"
    override val time_entry_label = "Uhrzeit"
    override val channel_name_notify = "ToDo Übersicht"
    override val channel_description_notify = "ToDo Übersicht"
    override val darkmode_button = "Dark Mode"
    override val lightmode_button = "Light Mode"
    override val finishedOn = "Erledigt am"
    override val date_selection_dialog = "Datumsauswahl"
}

object English: Language {
    override val app_title = "Your ToDo Organizer"
    override val settings_page_title = "App Settings"
    override val new_todo_title = "New ToDo"
    override val old_todo_title = "Done ToDo's"
    override val edit_todo_title = "Edit ToDo"
    override val create_entry_button = "New"
    override val update_entry_button = "Confirm"
    override val new_todo_menu_button = "New ToDo"
    override val old_todos_menu_button = "Done ToDo's"
    override val calendar_menu_button = "Calendar"
    override val language_selection_button = "Language"
    override val no_open_entries_msg = "No open ToDo's present :D"
    override val no_closed_entries_msg = "No closed ToDo's present :P"
    override val new_entry_error_msg = "Creation of new ToDo failed!"
    override val new_entry_error_description_msg = "Please check your inputs."
    override val title_entry_label = "Title"
    override val priority_entry_label = "Priority (1-5)"
    override val date_entry_label = "Duedate"
    override val time_entry_label = "Time"
    override val channel_name_notify = "ToDo Overview"
    override val channel_description_notify = "ToDo Overview"
    override val darkmode_button = "Dark Mode"
    override val lightmode_button = "Light Mode"
    override val finishedOn = "Closed on"
    override val date_selection_dialog = "Date Selection"
}

private val appLanguages: List<Language> = listOf(German, English)

val supportedLangs: List<String> = listOf("DE", "EN")

val supportedLanguages: List<String> = listOf("Deutsch", "English")