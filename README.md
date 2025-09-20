# README — omp2000 Assignment 1
**Author:** Declan Hourigan (47282762)

**Overview**

This repository contains my submission for Assignment 1. The project builds on the Week‑5 grid and expands it into a small, extendable grid-based demo that demonstrates object-oriented design principles required by the brief. The main additions are: multiple terrain types, passive items placed on cells, drawable actors that can pick up items, a simple Swing renderer for live demonstration, and a custom generic container for items.

> Important: actors do not keep an inventory. When an actor picks up an item the item is removed from the cell and a console message is printed.

---

## What I added:

* Multiple terrain `Cell` subclasses: `GrassCell`, `WaterCell`, `SandCell`.
* `Item` implementations: `Bone`, `Fish` (examples of passive items that can be picked up).
* `ItemBag<T extends Item>`: a custom generic container attached to each `Cell` for type-safe item storage.
* `Actor` base class and concrete actors: `Dog`, `Cat`, `Bird`. Actors draw themselves and can attempt to pick up items from their current cell.
* `Stage` — a minimal Swing window and canvas that render the grid and actors and accept keyboard input for simple interactions.

This design deliberately emphasises **inheritance**, **interfaces**, and **generics**.

---

## Why this demonstrates key concepts

### Inheritance

* `Cell` is an abstract base class containing common geometry and drawing behaviour. Concrete terrain classes extend `Cell` to provide specific visuals (colour) or future behaviour. This reduces duplication and makes it easy to add new terrain types.
* `Actor` is a base class for moving entities. `Dog`, `Cat`, and `Bird` override drawing behaviour. Common actor behaviour (positioning, pickup attempt) is implemented once in `Actor`.

### Interfaces

* `Drawable` provides a single `draw(Graphics g, Point topLeft)` contract used by cells, items and actors. This makes rendering code simple and decoupled from concrete types.
* `Interactable` provides a contract for objects that can be acted upon. `Item` extends both `Drawable` and `Interactable`, making items uniformly drawable and interactive.

### Generics

* `ItemBag<T extends Item>` is a custom generic class that stores items of type `T`. This demonstrates using generics beyond merely declaring collections: the class itself is generic and enforces type constraints at compile time.

---

## File map 

* `Main.java` — program entry (constructs grid and stage)
* `Stage.java` — Swing window and `Canvas` inner class; `paintComponent` renders cells then actors; keyboard handling also lives here
* `Grid.java` — builds the `Cell[][]`, places sample items, constructs actors array
* `Cell.java` — abstract base class which owns an `ItemBag<Item>` and implements common drawing logic
* `GrassCell.java`, `WaterCell.java`, `SandCell.java` — concrete terrain types
* `Item.java`, `Bone.java`, `Fish.java` — item interface and examples
* `ItemBag.java` — `ItemBag<T extends Item>` generic container
* `Actor.java` — base actor with `tryPickup` and `notifyPickup`
* `Dog.java`, `Cat.java`, `Bird.java` — concrete actor types

---

## How item pickup works (no inventory)

1. An actor calls `tryPickup(Cell[][] grid)` which locates the `Cell` at the actor's `(col,row)` coordinates.
2. If the cell's `ItemBag` contains one or more items, the first item is selected.
3. The actor calls `item.interact(this)` on that item; the item implementation usually calls `actor.notifyPickup(this)` which prints a console message.
4. The item is then removed from the `ItemBag` so it disappears visually from the grid.

This is intentionally lightweight: it demonstrates interaction without adding inventory complexity.

---

## How to compile & run (marker instructions)


1. Open a terminal/command prompt in the project directory (the folder containing `Main.java`).

2. Compile all files:
Make sure to be in the correct directory:
"*\comp2000_2025\src\Main.java"
```bash
javac *.java
```

3. Run the program:

```bash
java Main
```

Expected result: a Swing window titled **Grid Stage** appears. The console prints an instruction line and later prints messages such as `Rex picked up: BoneA` when items are collected.



---

## Controls

* `1` — actor 0 (first actor in the grid's actor array) attempts to pick up the first item in its cell. Check the console for a pickup message.
* `m` — move actor 0 one cell to the right (demo movement) and repaint the canvas.

---




