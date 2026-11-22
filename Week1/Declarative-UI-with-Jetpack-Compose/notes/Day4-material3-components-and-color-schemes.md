# Day 4: Material Design 3 components and color schemes

- `MaterialTheme` exposes three systems: `colorScheme`, `typography`, `shapes`. Composables read them via `MaterialTheme.colorScheme.primary`, etc., so changing the theme restyles the whole app.
- A color scheme is a set of roles, not raw colors: `primary` / `onPrimary`, `primaryContainer` / `onPrimaryContainer`, `secondary`, `tertiary`, `surface`, `background`. Every "on" color is the readable content color for its pair.
- `lightColorScheme(...)` and `darkColorScheme(...)` build the two variants; unspecified roles fall back to the baseline defaults.
- Dynamic color (Android 12+) derives the scheme from the wallpaper. Turn it off to show a brand palette.
- Typography: a `Typography` object with 15 styles (display, headline, title, body, label x large/medium/small). Override only what you need.
- Scaffold lays out the standard slots: `topBar`, `bottomBar`, `snackbarHost`, `floatingActionButton`, and content that must apply the `innerPadding` it receives.
- `TopAppBar` is still marked `@ExperimentalMaterial3Api` in this Material 3 version, so it needs `@OptIn`.
