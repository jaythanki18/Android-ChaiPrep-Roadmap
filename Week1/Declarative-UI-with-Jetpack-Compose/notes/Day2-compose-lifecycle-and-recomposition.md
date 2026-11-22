# Day 2: Compose lifecycle and recomposition

## Composable lifecycle
A composable goes through three events:
1. Enters the composition (first run, initial composition).
2. Recomposes zero or more times.
3. Leaves the composition (removed from the UI tree; its `remember`ed values are dropped).

## What triggers recomposition
- Compose tracks which `State<T>` objects each composable reads during composition.
- Writing a new value to a `State` (`mutableStateOf`, `mutableIntStateOf`, ...) invalidates the scopes that read it, and they re-run on the next frame.
- Plain variables are not observed: changing them does not recompose.
- Changed parameters also trigger recomposition of the callee, unless Compose can skip it (stable params that are equal).

## Rules of thumb
- Composables can run often, in any order, even in parallel: keep them free of side effects.
- `remember` keeps a value across recompositions; `rememberSaveable` also survives rotation / process death.
- Recomposition is smart: only scopes that read the changed state re-run, others are skipped.
- Side effects belong in `LaunchedEffect`, `DisposableEffect`, `SideEffect` (later topics).

## Modifiers
- Order matters: `padding().background()` differs from `background().padding()`.
- A custom modifier can be a plain extension function: `fun Modifier.dimWhen(d: Boolean) = this.alpha(...)`.
- Reusable components should take a `modifier: Modifier = Modifier` parameter as the first optional one.

## Previews
- `@Preview` renders a composable in Android Studio without running the app (must be parameterless).
- Options: `name`, `showBackground`, `uiMode` (dark mode), `fontScale`, `locale`, `widthDp`/`heightDp`.
- Several `@Preview` annotations on one function render each configuration side by side.
