# Repository Guidelines

## Project Structure & Module Organization
The Spring Boot entrypoint lives in `src/main/java/com/coinbot/coinbot/CoinbotApplication.java`. Domain models sit under `domain`, reusable trading logic under `core`, and exchange adapters under `service`. Shared resources and default configuration live in `src/main/resources`, while tests mirror production packages in `src/test/java/com/coinbot/coinbot`.

## Build, Test, and Development Commands
Use `./gradlew bootRun` to launch the local API server with live reload. `./gradlew test` runs the JUnit 5 suite and fails the build on any assertion failures. `./gradlew clean build` creates the runnable jar and executes the full verification pipeline; run it before pushing. Add `-Dspring.profiles.active=local` when you need profile-specific configuration.

## Coding Style & Naming Conventions
Target Java 24 with 4-space indentation. Classes and enums use UpperCamelCase, methods and fields stay lowerCamelCase, and constants rely on SCREAMING_SNAKE_CASE. Keep packages nested under `com.coinbot.coinbot`. Favor Lombok annotations for boilerplate but document non-trivial builders or configuration objects. Format imports within your IDE before committing.

## Testing Guidelines
Place unit tests beside the corresponding package using the `{ClassName}Tests` suffix. Cover each trigger, action, and service path with at least one focused test. Prefer mocking exchange clients; only integrate with the embedded H2 database in `@SpringBootTest` scenarios. Run `./gradlew test` before every pull request and share coverage deltas when behavior changes.

## Commit & Pull Request Guidelines
Write commit subjects in the imperative mood, ≤50 characters, e.g., `Add price trigger validation`. Reference issues with `#123` in the body when relevant. Pull requests should summarize the change, list impacted commands, and note configuration updates. Include screenshots or curl examples for API endpoints and call out breaking changes prominently.

## Configuration & Secrets
Store defaults in `src/main/resources/application.properties` and create `application-{profile}.properties` for overrides. Keep credentials in environment variables or ignored `.env` files—never commit API keys. Document required secrets and profile flags in pull request descriptions so reviewers can reproduce the scenario.
