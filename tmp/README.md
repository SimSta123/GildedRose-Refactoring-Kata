# Gilded Rose – Refactoring Decisions

## 1. Readability cleanups (no behavior change)
- **1.1. - Extract loop variable** – replaced `items[i]` with a single `item` reference.
- **1.2. - Named constants** – introduced constants for item names and for
  `MIN_QUALITY` / `MAX_QUALITY` instead of magic strings/numbers.

## 2. Quality helpers
- Introduced `increaseQuality` / `decreaseQuality` helpers that automatically checks
against `MIN_QUALITY` and `MAX_QUALITY`, removing repeated boundary checks.

## 3. Split logic per item type
The nested `if/else` was broken into one method per item type:
- 3.1. Sulfuras (extracted first – it does nothing)
- 3.2. Aged Brie
- 3.3. Backstage Passes
- 3.4. Regular item

## 4. Final cleanup
Removed unnecessary `return` statements.

## Challenges
- **Tracing item behavior:** It was tricky finding a way through the nested
  `if/else` statements to find the behavior of each item. But once some helper functions
  were introduced, it became easier to follow the logic.
