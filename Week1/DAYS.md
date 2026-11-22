# Week 1 log: Declarative UI with Jetpack Compose

## Day 1
Task: Read declarative vs imperative; Practise profile screen (Column/Row/Box); Practise state hoisting counter.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `notes/Day1-declarative-vs-imperative.md` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day1/ProfileScreen.kt` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day1/CounterScreen.kt` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/MainActivity.kt` (replaced Greeting with `Day1Screen`: profile + counter below)

Verify: open in Android Studio, sync Gradle, run on an emulator (profile with counter below; counter survives rotation), or view the @Preview functions.

## Day 2
Task: Read Compose lifecycle and recomposition; Practise reusable custom button with custom modifiers; Practise @Preview annotations for different configurations.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `notes/Day2-compose-lifecycle-and-recomposition.md` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day2/ChaiButton.kt` (new: `ChaiButton` with Filled/Outlined styles, custom modifiers `chaiElevated` and `dimWhen`, 7 previews: filled, outlined, disabled, dark, large font, light+night combined)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day2/RecompositionDemo.kt` (new: two independent state counters showing what recomposes)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/MainActivity.kt` (added `RecompositionDemo()` below the Day 1 content)

Verify: open in Android Studio, sync Gradle, run on an emulator (Tap / Add cup buttons; Add cup disables and dims at 5), or open ChaiButton.kt and view the previews in the Preview pane.

## Day 3
Task: Read LazyColumn and LazyRow; Practise scrollable contact list with dynamic data; Practise item keys in LazyColumn.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `notes/Day3-lazy-lists-and-keys.md` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day3/ContactListScreen.kt` (new: `Contact` model, `ContactListScreen` with a LazyRow of favourites, a LazyColumn of 30 contacts using `key = { it.id }`, Add contact / Remove first buttons on a `mutableStateListOf`, preview)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/MainActivity.kt` (Scaffold now shows `ContactListScreen`; `Day1Screen` is kept but no longer shown, since a lazy list can't live inside a non-scrolling Column)

Verify: open in Android Studio, sync Gradle, run on an emulator (scroll the list, tap Add contact / Remove first), or view the preview in ContactListScreen.kt.
