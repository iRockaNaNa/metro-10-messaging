# Metro 10 Messaging

An open-source Android messaging app that recreates the **Windows 10 Mobile**
Messaging experience — a clean conversation list, the classic chat thread
layout, and the 20-color accent palette — as a companion to
[Metro 10 Launcher](https://github.com/iRockaNaNa/metro-10-launcher).

> **Design reference:** the Windows 10 Mobile Messaging app. The MetroV suite
> (by Tuan Nguyen) proves the companion-app model on Android, but MetroV is
> based on Windows Phone 8.1 — this project is the Windows 10 Mobile take,
> in native Kotlin. MetroV is not affiliated with this project, and this
> project is not affiliated with Microsoft.

## Status

Early scaffold: the app shows the conversation list in Windows 10 Mobile
style with sample data. Real SMS support is the first roadmap milestone.

## Features (planned)

- **Conversation list** — Windows 10 Mobile Messaging layout, accent-colored
  unread states
- **Chat threads** — the classic Windows 10 Mobile thread view
- **Real SMS/MMS** — threads read from the Android Telephony provider
- **Send & receive** — including becoming the default SMS app
- **Accent sync** — match the Metro 10 Launcher accent palette

## Roadmap

- [ ] Conversation list UI (scaffold — sample data)
- [ ] Chat thread UI
- [ ] Read real SMS threads (Telephony provider)
- [ ] Send SMS
- [ ] Default SMS app role + notifications
- [ ] Accent color sync with Metro 10 Launcher

## Tech

Kotlin + Jetpack Compose (Material3), minSdk 29, targetSdk 34 — the same
stack as Metro 10 Launcher.
