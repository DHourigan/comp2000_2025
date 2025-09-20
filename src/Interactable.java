public interface Interactable {
    // Called when an actor tries to interact with this object (e.g., pick up an item)
    void interact(Actor actor);
};