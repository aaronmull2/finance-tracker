### ADR-001: Money Representation

**Date:** 2026-10-06
**Status:** Proposed
**Blockers:** Awaiting Money class to be developed 

#### Context
- Financial figures must be **exact**
- `double / float` can introduce rounding errors
- Single consistent data type is necessary across the application

#### Decision
Use of a `BigDecimal` decimal limits these errors, especially with Java function of `RoundingMode.HALF_EVEN`. Stored as `NUMERIC(19,4)` in Postgres. A shared `Money` Class ensures the rule is present globally.

#### Consequences
**Good:**
- No rounding errors and precise data matching the financial theme of application.
- Postgres preseves the same precision as Java -- No loss between code and db

**Bad / Trade-offs:**
- `BigDecimal` needs explicit rounding to ensure correct data, this **MUST** be done throughout.
- Divisions and percentages require more care

#### Alternatives considered
- **`double`/`float`** — Not precise enough for the application, can introduce rounding errors leading to false information
- **`long`** — Requires  conversions constantly and leads to less readability
