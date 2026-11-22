# ChaiPrep Android Roadmap

Repo for the ChaiPrep Android development roadmap: 6 weeks, one project per week, 7 daily tasks per project.

## Structure
- `Week1` … `Week6`: one Android (Kotlin) project per week.
- Each week's project contains 7 days of tasks (Day 1 … Day 7), built incrementally. Day N builds on Day N-1.
- `ROADMAP.md`: the source of truth for what each week's project and each day's task requires. Read it before writing any code.

## Rules
- Work only inside the requested week's folder unless told otherwise.
- Implement exactly the day's task from `ROADMAP.md`; don't jump ahead to later days.
- Keep each day's work identifiable (a clear commit-sized change, and a short note in the week's `DAYS.md` log: day, task, files changed).
- Use Kotlin, and follow the stack the roadmap specifies (e.g. Jetpack Compose, Room, Retrofit). If the roadmap is silent, ask or pick modern defaults and say so.
- If `ROADMAP.md` is missing or the task is ambiguous, ask the user instead of guessing.

## Agent
Use the `chaiprep-roadmap` agent (`.claude/agents/chaiprep-roadmap.md`) for "do Week X Day Y" requests.
