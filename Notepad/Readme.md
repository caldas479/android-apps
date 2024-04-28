# Notepad

The activity wireframe intended for this application is represented below.

![wireframe](images/notepad_wirefram.png)

The app consists of three activities:
- The main activity (ListNotesActivity) displays the titles of existing notes and a button for creating a new note. When the user presses that button (New Note), a new activity is created, named CreateNoteActivity. When it presses a note title from the list results, a new activity is created, named ReadNoteActivity.
- The CreateNoteActivity shows: a view for typing the note title, another view for typing the note text, and two buttons: OK for accepting the note, and Cancel for canceling the note. Pressing either of the buttons terminates that activity, but if Ok is pressed, the new note will be accepted and the note list updated, otherwise the note will be discarded.
- The ReadNoteActivity shows: the title and the content of that note. To terminate that activity the user must press the BACK button. 
