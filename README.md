# Reverse Engineering

This repository is to learn reverse engineering for android applications.

Tools needed:

- adb
- apktool

## How to use this repo

Every chapter (eg. ch01) has the app code with debugging info and the `.apk` file.

You could either [clone the repo](#clone-the-repo), and then install the app and then pull the `.apk` file [using adb](#pull-the-app-using-adb) (Android Debug Bridge), or use the `app.apk` file directly inside each chapter.

After having the app we will [decode](#decode-the-app) and then do some crazy stuff.

### Clone the repo

```bash
git clone https://github.com/kalikaruto/reverse-engineering.git
```

### Pull the app using adb

```bash
# 1. GET THE PROPER APP NAME
adb shell pm list packages | grep <APP-NAME>

# 2. GET THE PATH
adb shell pm path <OUT-FROM-PREV-CMD>   # without the "package:"

# 3. PULL THE APP
adb pull <OUT-FROM-PREV-CMD>   # without the "package:"

## e.g. for app named ComposeQuad
adb shell pm list packages | grep compose
package:com.learning.composequad

adb shell pm path com.learning.composequad
package:/data/app/~~37TFMu4S1OFJy31tPULR3w==/com.learning.composequad-eQVOt2ORpTuQps_6oxXpxg==/base.apk

adb pull /data/app/~~37TFMu4S1OFJy31tPULR3w==/com.learning.composequad-eQVOt2ORpTuQps_6oxXpxg==/base.apk

/data/app/~~37TFMu4S1OFJy31tPULR3w==/com.learning.composequad-eQVOt2ORpTuQps_6oxXpxg==/base.apk: 1 file pulled, 0 skipped. 33.7 MB/s (9596879 bytes in 0.272s)

```

### Decode the app

```bash
apktool d base.apk

# If you get error it probably means the memory allocatied for jvm was less.
# To increase to 4GB do either one
apktool -JXmx4G d base.apk  # you can set to 4, 6, 8 gb

# or
export _JAVA_OPTIONS="-Xmx4G"
apktool d base.apk
```
