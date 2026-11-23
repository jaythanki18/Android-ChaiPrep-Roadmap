# Day 6: Canvas, DrawScope and custom shapes

- `Canvas(modifier) { ... }` is a composable that gives you a `DrawScope`: a drawing receiver with `size`, `center`, and draw functions (`drawRect`, `drawRoundRect`, `drawCircle`, `drawLine`, `drawArc`, `drawPath`, `drawImage`). It is `Spacer` plus `drawBehind`.
- Inside DrawScope, coordinates are in pixels with the origin at top-left. Use `dp.toPx()` to convert units. `size.width` / `size.height` are the measured canvas size.
- Drawing happens in the draw phase, not composition. If you read animated state only inside the draw lambda, Compose can skip recomposition and redraw only. Here the value comes from `animateFloatAsState`, so the bar animates smoothly.
- Related modifiers: `Modifier.drawBehind { }` (draw under content), `Modifier.drawWithContent { drawContent() }` (draw over or around content), `Modifier.drawWithCache` (reuse allocated Paths/Brushes until size changes).
- Helpers: `withTransform { rotate/translate/scale }`, `clipPath`, `inset`, `Brush.linearGradient`, `Stroke(width, cap, join)`, `StrokeCap.Round`.
- A custom `Shape` implements `createOutline(size, layoutDirection, density): Outline`. Return `Outline.Rectangle`, `Outline.Rounded`, or `Outline.Generic(path)` for arbitrary geometry. Use it with `Modifier.clip(shape)`, `background(color, shape)`, `border`, or `Surface(shape = ...)`.
- `clip` masks content, so the same shape works for an `Image`, a colored `Box`, or any other child. Build the Path from `size` so the shape scales with the component.
- Keep Shapes stateless (an `object` or a data class) so they are cheap and stable.
