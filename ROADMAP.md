# ChaiPrep Android Roadmap

Each sprint = one week = one project in `WeekN/`. Each day has Read (study) and Practise (code) items.

## Sprint 1 (Week 1): Declarative UI with Jetpack Compose
Mastering UI components, state hoisting, and layout systems.
Project: `Week1/Declarative-UI-with-Jetpack-Compose`

### Day 1
- Read: Understand the declarative paradigm vs imperative XML views
- Practise: Create a simple profile screen using Column, Row, and Box layouts
- Practise: Implement state hoisting to manage a counter variable in a Composable

### Day 2
- Read: Learn the Compose lifecycle and how recomposition is triggered
- Practise: Build a reusable custom button component with custom modifiers
- Practise: Use Preview annotations to visualize components in different configurations

### Day 3
- Read: Study LazyColumn and LazyRow for efficient list rendering
- Practise: Build a scrollable contact list with dynamic data items
- Practise: Implement item keys in LazyColumn to optimize list performance

### Day 4
- Read: Explore Material Design 3 components and color schemes
- Practise: Apply a custom theme to an app with typography and color palettes
- Practise: Implement a Scaffold with TopAppBar and FloatingActionButton

### Day 5
- Read: Learn animation APIs: AnimatedVisibility and animateContentSize
- Practise: Add an expand/collapse animation to a list item
- Practise: Create a crossfade transition between two UI states

### Day 6
- Read: Understand Canvas and DrawScope for custom graphics
- Practise: Draw a custom progress bar using DrawScope
- Practise: Implement a custom shape for an image component

### Day 7
- Read: Study accessibility guidelines and semantic properties
- Practise: Add content descriptions and merge semantic nodes for screen readers

## Sprint 2 (Week 2): Architecture and State Management
Structuring apps with MVVM and reactive state flows.
Project: `Week2/Architecture-and-State-Management`

### Day 8
- Read: Understand the ViewModel lifecycle and its role in configuration changes
- Practise: Refactor a screen to move business logic into a ViewModel
- Practise: Use ViewModelProvider to inject dependencies into a ViewModel

### Day 9
- Read: Learn StateFlow and SharedFlow for reactive data streams
- Practise: Expose UI state from a ViewModel using StateFlow
- Practise: Collect state in Compose using collectAsStateWithLifecycle

### Day 10
- Read: Study the MVVM pattern and separation of concerns
- Practise: Define a sealed class to represent distinct UI states (Loading, Success, Error)
- Practise: Map domain models to UI state objects in the ViewModel

### Day 11
- Read: Learn to handle one-time events (side effects) like toasts or navigation
- Practise: Use a Channel to emit one-time events from the ViewModel
- Practise: Consume events in the UI using LaunchedEffect

### Day 12
- Read: Understand savedInstanceState and process death
- Practise: Use SavedStateHandle to persist small amounts of data in a ViewModel
- Practise: Restore UI state after a process kill simulation

### Day 13
- Read: Learn about UI state modeling best practices
- Practise: Create a complex UI state data class for a dashboard screen
- Practise: Implement a reducer-like function to update state immutably

### Day 14
- Read: Understand manual dependency injection basics
- Practise: Create a simple service locator to provide dependencies

## Sprint 3 (Week 3): Networking and Data Persistence
Handling remote APIs and local database storage.
Project: `Week3/Networking-and-Data-Persistence`

### Day 15
- Read: Learn Retrofit setup and Kotlin Serialization for API calls
- Practise: Define a Retrofit interface for a public REST API
- Practise: Create a data transfer object (DTO) and parse JSON response

### Day 16
- Read: Understand Room database entities and DAOs
- Practise: Define a Room entity and a corresponding DAO interface
- Practise: Initialize a Room database instance

### Day 17
- Read: Learn the Repository pattern for data abstraction
- Practise: Create a repository that mediates between Remote and Local data sources
- Practise: Implement a fetch-and-cache strategy in the repository

### Day 18
- Read: Understand DataStore for simple key-value preferences
- Practise: Implement a settings manager using Preferences DataStore
- Practise: Observe settings changes in the UI

### Day 19
- Read: Learn robust error handling for network requests
- Practise: Create a custom Result wrapper class for network operations
- Practise: Display appropriate error messages in the UI based on network status

### Day 20
- Read: Understand Room database migrations
- Practise: Write a migration script for adding a column to an existing table
- Practise: Test the migration using Room's migration test helper

### Day 21
- Read: Learn caching strategies for offline-first apps
- Practise: Implement a simple TTL (Time-To-Live) cache for API responses

## Sprint 4 (Week 4): Navigation and Lifecycle
Managing screen flow and lifecycle-aware components.
Project: `Week4/Navigation-and-Lifecycle`

### Day 22
- Read: Understand the Compose Navigation library architecture
- Practise: Setup a NavHost and define routes for an app
- Practise: Create a navigation controller and navigate between screens

### Day 23
- Read: Learn to pass arguments between navigation destinations
- Practise: Pass a data object via navigation route using Type-Safe navigation
- Practise: Retrieve arguments in the destination Composable

### Day 24
- Read: Understand deep links and intent handling
- Practise: Configure a deep link in the navigation graph
- Practise: Handle an incoming intent to navigate to a specific screen

### Day 25
- Read: Learn to implement Bottom Navigation bars
- Practise: Create a BottomNavigation component with multiple tabs
- Practise: Sync bottom bar selection with the current navigation route

### Day 26
- Read: Understand nested navigation graphs
- Practise: Create a nested graph for a specific feature module
- Practise: Navigate from the main graph into a nested graph

### Day 27
- Read: Learn lifecycle-aware components in Compose
- Practise: Use LifecycleEventObserver to react to app backgrounding
- Practise: Use repeatOnLifecycle to collect flows safely

### Day 28
- Read: Understand back press handling in Compose
- Practise: Implement a custom BackHandler to intercept back navigation

## Sprint 5 (Week 5): Concurrency and Background Tasks
Using Coroutines and WorkManager for asynchronous work.
Project: `Week5/Concurrency-and-Background-Tasks`

### Day 29
- Read: Understand Coroutines basics: launch, async, and suspend functions
- Practise: Launch a coroutine in a ViewModelScope
- Practise: Use async/await to perform parallel network requests

### Day 30
- Read: Learn Dispatchers and thread context switching
- Practise: Switch to Dispatchers.IO for database operations
- Practise: Switch to Dispatchers.Main for UI updates

### Day 31
- Read: Understand structured concurrency and Job cancellation
- Practise: Cancel a long-running coroutine when the user navigates away
- Practise: Use CoroutineScope to manage lifecycle-bound tasks

### Day 32
- Read: Learn WorkManager for deferrable background tasks
- Practise: Schedule a one-time background worker
- Practise: Define constraints (e.g., network, charging) for a worker

### Day 33
- Read: Understand PeriodicWorkRequest and task chaining
- Practise: Schedule a periodic sync task
- Practise: Chain multiple workers using WorkContinuation

### Day 34
- Read: Learn advanced Flow operators (combine, flatMapLatest, debounce)
- Practise: Use debounce to filter rapid user input in a search bar
- Practise: Combine multiple data streams using combine operator

### Day 35
- Read: Understand exception handling in coroutines
- Practise: Use try-catch and CoroutineExceptionHandler to handle errors

## Sprint 6 (Week 6): Dependency Injection and Testing
Scaling with Hilt and writing testable code.
Project: `Week6/Dependency-Injection-and-Testing`

### Day 36
- Read: Understand Hilt setup and dependency modules
- Practise: Annotate the Application class with HiltAndroidApp
- Practise: Create a Hilt module to provide a Retrofit instance

### Day 37
- Read: Learn Hilt scoping (ActivityRetainedComponent, SingletonComponent)
- Practise: Scope a repository to the SingletonComponent
- Practise: Inject a ViewModel using HiltViewModel annotation

### Day 38
- Read: Understand unit testing ViewModels with Turbine
- Practise: Write a unit test to verify ViewModel state changes
- Practise: Use Turbine to test StateFlow emissions

### Day 39
- Read: Learn UI testing with Compose Test Rule
- Practise: Write a UI test to verify button click triggers navigation
- Practise: Use semantic matchers to find UI elements in tests

### Day 40
- Read: Understand mocking dependencies for tests
- Practise: Use MockK to mock a repository in a ViewModel test
- Practise: Verify function calls on a mocked dependency

### Day 41
- Read: Learn integration testing basics
- Practise: Write an integration test for the repository and Room database
- Practise: Use an in-memory database for testing

### Day 42
- Read: Understand Proguard and R8 optimization
- Practise: Configure R8 rules to keep necessary classes for serialization
