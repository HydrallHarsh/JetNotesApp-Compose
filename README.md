# Notes App

A simple Notes App built using Jetpack Compose and Kotlin. This app demonstrates CRUD operations with Room, dependency injection with Dagger Hilt, and follows the principles of Clean Architecture and MVVM (Model-View-ViewModel) design pattern.

## Features

- **Create, Read, Update, Delete (CRUD) Operations**: Manage your notes efficiently.
- **Room**: Local database for storing notes.
- **Dagger Hilt**: Dependency injection framework for managing app dependencies.
- **Clean Architecture**: Separation of concerns with different layers.
- **ViewModel**: Manage UI-related data in a lifecycle-conscious way.

## Technologies Used

- **Kotlin**: Programming language for Android development.
- **Jetpack Compose**: Modern toolkit for building native UI.
- **Room**: Database library for Android.
- **Dagger Hilt**: Dependency injection library.

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/Notes-App.git
    ```
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Usage

1. **Adding a Note**: Click on the add button and enter your note.
2. **Viewing Notes**: All saved notes will be displayed on the home screen.
4. **Deleting a Note**: Click on the Notes to Delete

## Architecture

The app follows Clean Architecture principles, separating the project into different layers:

- **Presentation Layer**: Contains UI components and ViewModels.
- **Domain Layer**: Contains use cases and repository interfaces.
- **Data Layer**: Contains repository implementations and data sources (local database).

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.


## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Room](https://developer.android.com/training/data-storage/room)
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
