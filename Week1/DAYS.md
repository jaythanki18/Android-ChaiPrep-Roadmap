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

## Day 4
Task: Read Material Design 3 components and color schemes; Practise custom theme with typography and color palettes; Practise Scaffold with TopAppBar and FloatingActionButton.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `notes/Day4-material3-components-and-color-schemes.md` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/ui/theme/Color.kt` (replaced default purples with a chai palette: brown, cardamom, saffron, cream/espresso)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/ui/theme/Type.kt` (serif titleLarge/titleMedium, plus bodyLarge and labelLarge)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/ui/theme/Theme.kt` (light/dark schemes use the palette; `dynamicColor` now defaults to false so the custom palette shows)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day4/ChaiScaffoldScreen.kt` (new: Scaffold with TopAppBar, FAB showing a Snackbar, hosts `ContactListScreen`; light and dark previews)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/MainActivity.kt` (now shows `ChaiScaffoldScreen` instead of its own Scaffold around `ContactListScreen`)

Verify: open in Android Studio, sync Gradle, run on an emulator (themed top bar, contact list, FAB shows "Chai ordered!" snackbar; toggle system dark mode), or view the previews in ChaiScaffoldScreen.kt.

## Day 5
Task: Read animation APIs (AnimatedVisibility, animateContentSize); Practise expand/collapse animation on a list item; Practise a crossfade between two UI states.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day5/ExpandableContactRow.kt` (new: `ExpandableContactRow` using AnimatedVisibility + animateContentSize; `ContactsCrossfade` using Crossfade between empty state and list; preview)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day3/ContactListScreen.kt` (list now uses `ExpandableContactRow` and is wrapped in `ContactsCrossfade`)

Verify: open in Android Studio, sync Gradle, run on an emulator (tap a contact to expand/collapse; press Remove first repeatedly until empty to see the crossfade, then Add contact), or view the preview in ExpandableContactRow.kt.

## Day 6
Task: Read Canvas and DrawScope for custom graphics; Practise a custom progress bar using DrawScope; Practise a custom shape for an image component.

Files (under `Declarative-UI-with-Jetpack-Compose/`):
- `notes/Day6-canvas-and-custom-shapes.md` (new)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day6/ChaiProgressBar.kt` (new: `ChaiProgressBar` drawn with Canvas/DrawScope, animated fill, quarter ticks; preview)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day6/HexagonShape.kt` (new: custom `HexagonShape` (Outline.Generic path) and `HexagonAvatar` clipped to it; preview)
- `app/src/main/java/com/example/declarative_ui_with_jetpack_compose/day3/ContactListScreen.kt` (shows `ChaiProgressBar` of contacts out of 30; avatars now use `HexagonAvatar`; unused imports removed)

Verify: open in Android Studio, sync Gradle, run on an emulator (progress bar under Favourites animates as you Add/Remove contacts; avatars are hexagons), or view the previews in the day6 files.
