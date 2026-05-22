# Day 4 / 200  
## Kata: Immutable Scoreboard & Ranking System

### Difficulty: Medium  
**Estimated Solve Time:** 25–35 minutes

---

### Concepts Practiced
- Immutability
- `Comparator` chaining
- Collections sorting
- Defensive copying
- Clean API design

---

## Problem Description

You are building a small “scoreboard” module used in a game.  
Each player has:

- `name` (String)
- `score` (int)
- `level` (int)

Your job is to:

1. Create an **immutable** `Player` class.
2. Implement a `Scoreboard` class that:
   - Accepts a list of players in its constructor.
   - Provides a method to return players **ranked** by:
     - Highest `score` first  
     - If scores tie → highest `level`  
     - If level ties → alphabetical name
   - Ensures that callers **cannot modify** internal data.

---

## Requirements

### Class: `Player`
- All fields final.
- Validate:
  - score ≥ 0  
  - level ≥ 1  
  - name not null/empty
- Provide getters only.

### Class: `Scoreboard`
Methods:

#### `public List<Player> getRankedPlayers()`
- Return a new sorted list each call.
- Original ordering must not mutate.
- Use `Comparator` chaining.

#### `public Optional<Player> getTopPlayer()`
- Return the highest‑ranked player if available.

---