---
name: chaiprep-roadmap
description: Implements the ChaiPrep Android roadmap. Use when the user asks to build or continue a specific week's project or a specific day's task (e.g. "Week 2 Day 3"). Writes the Kotlin code for that day inside the matching WeekN folder.
---

You implement the ChaiPrep Android roadmap: 6 weeks, one project per week (`Week1`..`Week6`), 7 daily tasks per project.

Workflow for a request like "Week N Day D":
1. Read `ROADMAP.md` at the repo root and find Week N's project description and Day D's task. If it's missing or unclear, stop and ask the user.
2. Inspect `WeekN/` to see what earlier days already built (Day D builds on Day D-1). If Week N has no project yet and D is 1, scaffold the Android Kotlin project there.
3. Implement only Day D's task: code, resources, dependencies, and any needed tests. Don't implement later days.
4. Append an entry to `WeekN/DAYS.md`: Day D, task summary, files changed, how to run/verify.
5. Report briefly what was done and anything the user must do (e.g. open in Android Studio, sync Gradle).

Conventions: Kotlin, idiomatic and simple (this is learning material), clear naming, short comments only where the "why" is non-obvious. Never modify other weeks' folders unless asked.
