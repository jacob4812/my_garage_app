# Status implementacji — „Mój Garaż”

Statusy: `GOTOWE`, `W TRAKCIE`, `NIEZROBIONE`, `NIEZWERYFIKOWANE`.

## ETAP 1 — kompilujący szkielet aplikacji

| Obszar | Status | Uwagi |
|---|---|---|
| Zasady projektu w `AGENTS.md` | GOTOWE | Zapisano zasady języka, architektury, bezpieczeństwa i procesu pracy. |
| Projekt Android/Gradle w `android/` | NIEZWERYFIKOWANE | Utworzono moduł aplikacji, Gradle Kotlin DSL, wrapper, minSdk 26 i targetSdk 37; kompilacja wymaga Android SDK. |
| Interfejs Compose po polsku | NIEZWERYFIKOWANE | Utworzono polskie zasoby i ekrany Compose. |
| Dolna nawigacja | NIEZWERYFIKOWANE | Start, Narzędzia, Części, Inwentaryzacja i Więcej są zdefiniowane w Navigation Compose. |
| Ekran główny „Mój Garaż” | NIEZWERYFIKOWANE | Przygotowano ekran startowy bez fikcyjnych danych produkcyjnych. |
| Ekran ustawień | NIEZWERYFIKOWANE | Dostępny przez sekcję „Więcej”; zawiera komunikat o kolejnej wersji. |
| Prosty jasny i ciemny motyw | NIEZWERYFIKOWANE | Motyw Material 3 respektuje ustawienia systemu. |
| MVVM, Hilt i Coroutines | NIEZWERYFIKOWANE | Dodano ViewModel ekranu głównego, Hilt i dispatcher IO; brak funkcji danych zgodnie z zakresem etapu. |
| Podział `data`, `domain`, `presentation`, `di` | NIEZWERYFIKOWANE | Utworzono pakiety i opis warstwy danych; implementacja danych jest odroczona. |
| Podstawowe testy jednostkowe | NIEZWERYFIKOWANE | Dodano testy definicji pięciu sekcji nawigacji. |
| Struktura migracji Supabase | GOTOWE | Utworzono `supabase/migrations/`; brak migracji biznesowych zgodnie z zakresem etapu. |
| Androidowy i Supabase’owy `.gitignore` | GOTOWE | Dodano ignorowanie artefaktów budowania i konfiguracji lokalnej. |
| Supabase/PostgreSQL i RLS | NIEZROBIONE | Brak konfiguracji oraz migracji; nie dodano żadnych sekretów. |
| Room jako lokalny cache | NIEZROBIONE | Brak modułu lokalnej bazy. |
| Synchronizacja między uprawnionymi użytkownikami | NIEZROBIONE | Brak implementacji. |
| Atomowe zmiany ilości potwierdzane przez serwer | NIEZROBIONE | Brak implementacji funkcji serwerowych i klienta. |
| Testy i kompilacja | NIEZWERYFIKOWANE | Gradle uruchomiono, ale brak Android SDK uniemożliwił wyznaczenie zależności zadań. |

## Ręczne działania wymagane później

Na tym etapie należy ręcznie:

1. w Android Studio otworzyć katalog `android/`,
2. zainstalować Android SDK wymagane przez `compileSdk = 37`,
3. uruchomić `./gradlew testDebugUnitTest assembleDebug`.

W kolejnych etapach, przed konfiguracją Supabase, należy ręcznie:

1. utworzyć projekt Supabase oraz skonfigurować schemat PostgreSQL i polityki RLS,
2. dodać bezpieczną konfigurację klienta bez umieszczania `service_role` w aplikacji,
3. skonfigurować użytkowników i uprawnienia synchronizacji.
