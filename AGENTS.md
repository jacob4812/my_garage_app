# AGENTS.md — zasady projektu „Mój Garaż”

Ten plik zawiera obowiązujące zasady rozwoju aplikacji Android „Mój Garaż”. Należy stosować je podczas każdej kolejnej zmiany w repozytorium.

1. Cały interfejs użytkownika musi być po polsku. Teksty należy umieszczać w `strings.xml`.
2. Technologie projektu: Kotlin, Jetpack Compose, Material 3, MVVM, Hilt, Coroutines, Room oraz Supabase/PostgreSQL.
3. Narzędzia są głównym modułem aplikacji. Części i materiały są osobnym, drugorzędnym modułem.
4. Aplikacja działa na wielu telefonach i synchronizuje dane między uprawnionymi użytkownikami.
5. Supabase jest źródłem prawdy. Room może służyć jako lokalny cache.
6. Operacje zmieniające ilości muszą być atomowe i potwierdzane przez serwer.
7. Nie wolno implementować niezabezpieczonych zmian stanów ani omijać RLS.
8. Interfejs powinien być prosty, nowoczesny i oparty na Material 3.
9. Nie należy implementować funkcjonalności z kolejnych etapów, chyba że jest to konieczne do poprawnej architektury.
10. Nie należy usuwać istniejącego działającego kodu bez potrzeby.
11. Nie wolno dodawać atrap, fikcyjnych danych produkcyjnych ani pustych metod jako ukończonych funkcji.
12. Nie wykonuj automatycznie commitów ani pushowania.
13. Po każdej zmianie uruchom dostępne testy i kompilację. Jeśli środowisko na to nie pozwala, opisz ograniczenie.
14. Aktualizuj `README.md` oraz `docs/implementation-status.md`, oznaczając funkcje jako: `GOTOWE`, `W TRAKCIE`, `NIEZROBIONE` lub `NIEZWERYFIKOWANE`.
15. Na końcu każdego etapu podaj listę zmienionych plików, wyniki testów, instrukcję sprawdzenia funkcji i ewentualne problemy.
16. Nie korzystaj z płatnych API ani usług bez wyraźnego potwierdzenia właściciela projektu.
17. Nie umieszczaj haseł, tokenów ani klucza `service_role` w repozytorium.
18. Jeżeli wymagane są dane konfiguracyjne lub działania w zewnętrznym panelu, przygotuj instrukcję i wskaż czynności do wykonania ręcznie.

## Zasady pracy z konfiguracją i bezpieczeństwem

- Sekrety przekazuj lokalnie przez właściwą konfigurację środowiska lub plik ignorowany przez Git; do repozytorium trafiają wyłącznie bezpieczne przykłady konfiguracji.
- Klient Android może używać wyłącznie klucza przeznaczonego dla klienta i musi respektować polityki RLS. Klucz `service_role` pozostaje po stronie zaufanego backendu lub Supabase Edge Functions.
- Zmiany ilości i inne operacje współbieżne projektuj jako transakcje/procedury po stronie Supabase/PostgreSQL, z autoryzacją i odpowiedzią serwera.
- Przed zakończeniem etapu sprawdź dostępne testy i kompilację. Nie oznaczaj funkcji jako `GOTOWE`, jeśli nie została zweryfikowana.
