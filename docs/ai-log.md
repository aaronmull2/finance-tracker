## Rules
1. Require approvals from developer before allowing implementation of the next changes;
 - This include the explanation of code
 - Review Required before any implementation.

## Mistakes

| Date | What I asked | What went wrong | How I caught it |
|------|-------------|-----------------|-----------------|
| 2026-10-06 | Flyway auto-configuration | Flyway didn't run migrations — Spring Boot 4.x doesn't auto-configure Flyway the same way as 3.x | No tables found in DB; fixed by creating explicit `DatabaseConfig.java` bean |
| 2026-10-16 | Set up Testcontainers integration test | Testcontainers couldn't connect to Docker Desktop on Windows — named pipes returned Status 400 with empty data | Test failed; switched to docker-compose Postgres instead |