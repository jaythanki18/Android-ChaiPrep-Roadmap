# Day 1: Declarative UI vs imperative XML views

## Imperative (XML + Views)
- Layout lives in XML; behaviour lives in Kotlin/Java.
- You hold references (`findViewById` / ViewBinding) and mutate them: `textView.text = "5"`, `button.isEnabled = false`.
- You must keep every view in sync with the data by hand. Forget one update and the UI shows stale state.

## Declarative (Jetpack Compose)
- UI is a function of state: `UI = f(state)`.
- You describe what the screen looks like for the current state. When state changes, Compose re-runs (recomposes) only the affected composables.
- No view references, no manual "set text / set visibility" calls.

## Key ideas
- `@Composable` functions emit UI; they should be fast and free of side effects.
- `remember { mutableStateOf(x) }` keeps state across recompositions; writing to it schedules recomposition.
- Layouts: `Column` (vertical), `Row` (horizontal), `Box` (stacked/overlapping).
- State hoisting: move state up to the caller; the child receives `value` and `onValueChange` events (state down, events up). This makes the child stateless, reusable and testable.

## Quick comparison
| | XML Views | Compose |
|---|---|---|
| Describe UI | XML file | Kotlin functions |
| Update UI | Mutate views | Change state, UI recomposes |
| Source of truth | Views + data (can drift) | State only |
| Reuse | Custom views / includes | Plain composables |
