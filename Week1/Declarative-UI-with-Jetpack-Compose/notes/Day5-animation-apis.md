# Day 5: Animation APIs, AnimatedVisibility and animateContentSize

- Compose animations are state-driven: you change state and the animation APIs interpolate between the old and new UI. You never start or stop an animation imperatively.
- `AnimatedVisibility(visible = ...)` animates a composable entering and leaving the composition. The default is fade plus expand/shrink. Customize with `enter = fadeIn() + expandVertically()` and `exit = fadeOut() + shrinkVertically()`. Transitions combine with `+`.
- Other enter/exit transitions: `slideIn*`, `slideOut*`, `scaleIn`, `scaleOut`. Inside `AnimatedVisibility`, `Modifier.animateEnterExit` gives children their own transitions.
- `Modifier.animateContentSize()` animates the size change of a composable when its content changes (e.g. a `Text` going from `maxLines = 1` to unlimited). Put it before any size-affecting modifiers so it sees the size change. Pass an `animationSpec` such as `spring` or `tween` to tune it.
- Expand/collapse pattern: hoist a `var expanded by remember { mutableStateOf(false) }` per row, toggle it in `clickable`, and wrap the extra details in `AnimatedVisibility(expanded)`. In a lazy list, key state by item id so it survives scrolling and reordering.
- `Crossfade(targetState = ...)` switches between two UI states with a fade. Each state is a separate branch of the lambda, so it suits "list vs empty state" or "loading vs content". `AnimatedContent` is the more flexible version, with custom enter/exit transitions and size animation.
- `animate*AsState` (`animateColorAsState`, `animateDpAsState`, `animateFloatAsState`) animates a single value toward a target and is the lowest-level of the simple APIs.
- Animation specs: `spring` (default, physics-based), `tween` (duration + easing), `keyframes`, `snap`.
