# Courtyard Year Project

This is an Android application designed to automate the process of taking a photo of the same scene at the same time every day for a year. The goal is to collect a series of images that can be later compiled into a time-lapse video or slideshow.

## Features

*   **Daily Photo Capture:** The app automatically takes a photo at a user-defined time each day.
*   **Background Operation:** A foreground service ensures that the photo is taken even if the app is in the background or the device screen is off.
*   **Customizable Settings:** Users can configure:
    *   The exact time for the daily capture.
    *   The directory where the images are saved.
*   **Camera Preview:** The main screen shows a live preview from the camera.
*   **Status Notifications:** A persistent notification keeps the user informed about the service's status.

## Build

This project is configured to be built using GitHub Actions. A debug APK is automatically generated for every push to the `master` branch.