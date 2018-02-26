# Today On TV
[![works badge](https://cdn.rawgit.com/nikku/works-on-my-machine/v0.2.0/badge.svg)](https://github.com/nikku/works-on-my-machine)

TODO: Enable Travis CI for repo, appropriate `.travis.yml` already added.

Apologies for not completing a few things:
1. making the Show Activity UI more beautiful
2. making only one episode card expandable at a time
3. write more unit tests and integration tests

I'm on a vacation with my friends so I couldn't carve out any more time.

Other than the above mentioned things, I think I succeeded in achieving the main objectives for this project:
1. The app is functional and adhere to the Android material design guidelines.
2. The source code is structured in MVVM architecture, keeping scalability and maintainability in mind.
3. The min sdk is 17 and AppCompat is used so all platforms above Android 4.2 are supported.
4. I also implemented caching at okhttp level (see `RetrofitHelper.kt`).

## Building

1. Clone the git repository
2. Run `./gradlew build`

## Problem Statement

See the `problem.pdf` in project root dir.
