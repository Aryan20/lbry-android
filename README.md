# LBRY Android
[![pipeline status](https://ci.lbry.tech/lbry/lbry-android/badges/master/pipeline.svg)](https://ci.lbry.tech/lbry/lbry-android/commits/master)
[![GitHub license](https://img.shields.io/github/license/lbryio/lbry-android)](https://github.com/lbryio/lbry-android/blob/master/LICENSE)

An Android browser and wallet for the [LBRY](https://lbry.com) network.

### Modified dark theme
![modifiedlbry1](https://user-images.githubusercontent.com/34372791/161681766-a819eb45-652d-440f-be74-9b9826365caf.png)
![modifiedlbry2](https://user-images.githubusercontent.com/34372791/161681774-f456bbea-0034-4330-9b45-5287dd20fc20.png)



## Installation

### Modified Version -
By downloading the latest release from GitHub

### Original Version - 
The minimum supported Android version is 5.0 Lollipop. There are two ways to install:

1. Via the Google Play Store. Anyone can join the [open beta](https://play.google.com/apps/testing/com.aryan.lbrybrowser) in order to install the app from the Play Store.
1. Direct APK install available at [http://build.lbry.io/android/latest.apk](http://build.lbry.io/android/latest.apk). You will need to enable installation from third-party sources on your device in order to install from this source.

## Usage
The app can be launched by opening **LBRY** from the device's app drawer or via the shortcut on the home screen if that was created upon installation.

## Running from Source
Clone the repository and open the project in Android Studio. Android Studio will automatically run the initial build process.

Create file 'twitter.properties' in app/ folder with the following content:

```
twitterConsumerKey=XXXXXX

twitterConsumerSecret=XXXXXX
```

Copy the file 'google-services.sample.json' to 'google-services.json' in the app/ folder.

Click the Sync button and when process finishes, the Run button to launch the app on your simulator or connected debugging device after the build process is complete.

## Contributing
Contributions to this project are welcome and encouraged

## License
This project is MIT licensed. For the full license, see [LICENSE](LICENSE).

## Security
We take security seriously. Please contact security@lbry.com regarding any security issues. Our PGP key is [here](https://lbry.com/faq/pgp-key) if you need it.

## Contact

The primary contact for this project is [@Aryan20](https://github.com/Aryan20) (aryankaushik2023@gmail.com)

The primary contact for original project is [@akinwale](https://github.com/akinwale) (akinwale@lbry.com)

## Note

This project is neither supported nor affiliated by LBRY org, this is just a fun project that I did to make it look better for me
