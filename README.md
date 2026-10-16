# Mój Garaż

Aplikacja Android do zarządzania garażem, w której głównym modułem są narzędzia. Części i materiały będą osobnym, drugorzędnym modułem.

## Stan projektu

Zrealizowano ETAP 1: utworzono moduł Android w katalogu `android/`, podstawową architekturę Compose/MVVM oraz działającą nawigację przygotowaną do dalszego rozwoju. Logowanie, baza danych i zarządzanie narzędziami nie są jeszcze implementowane. Szczegółowy status znajduje się w [docs/implementation-status.md](docs/implementation-status.md).

## Założenia techniczne

- Kotlin, Jetpack Compose i Material 3
- MVVM, Hilt i Coroutines
- Supabase/PostgreSQL jako źródło prawdy
- Room wyłącznie jako opcjonalny lokalny cache
- synchronizacja danych między uprawnionymi użytkownikami
- atomowe operacje zmieniające ilości, potwierdzane przez serwer
- RLS i autoryzacja po stronie Supabase

## Weryfikacja

Wykonaj z katalogu `android/`:

```bash
./gradlew testDebugUnitTest assembleDebug
```

W tym środowisku kompilacja nie została ukończona, ponieważ nie ma zainstalowanego Android SDK (`ANDROID_HOME`/`local.properties`). Android Studio może pobrać wymagane SDK po otwarciu projektu.

## Otwarcie w Android Studio

1. Otwórz Android Studio.
2. Wybierz **Open** i wskaż katalog `android/`, a nie katalog główny repozytorium.
3. Zaakceptuj synchronizację Gradle i zainstaluj wskazane komponenty SDK, jeśli Android Studio o to poprosi.
4. Uruchom konfigurację `app` na emulatorze lub podłączonym urządzeniu z Androidem 8.0 (API 26) lub nowszym.

Projekt używa Gradle Kotlin DSL i zawiera wrapper Gradle. Nie dodano żadnych kluczy Supabase ani innych sekretów.

## Zasady projektu

Obowiązujące zasady pracy znajdują się w [AGENTS.md](AGENTS.md).
