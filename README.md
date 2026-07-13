# Courtyard Year Project

[![Build Debug APK](https://github.com/ChernegaSergiy/courtyard-year-project/actions/workflows/debug-build.yml/badge.svg)](https://github.com/ChernegaSergiy/courtyard-year-project/actions/workflows/debug-build.yml)
[![Validate Gradle Wrapper](https://github.com/ChernegaSergiy/courtyard-year-project/actions/workflows/gradle-wrapper-validation.yml/badge.svg)](https://github.com/ChernegaSergiy/courtyard-year-project/actions/workflows/gradle-wrapper-validation.yml)

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

This project is configured to be built using GitHub Actions. A debug APK is automatically generated for every push to the `main` branch.

## Contributing

Contributions are welcome and appreciated! Here's how you can contribute:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

Please make sure to update tests as appropriate and adhere to the existing coding style.

## License

This project is licensed under the CSSM Unlimited License v2.0 (CSSM-ULv2). See the [LICENSE](LICENSE) file for details.