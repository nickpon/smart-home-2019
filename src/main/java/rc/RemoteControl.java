package rc;

public interface RemoteControl {
    /**
     * This method will be called when a button buttonCode is pressed on a remote control with id rcId
     * @param buttonCode button letter: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”
     * @param rcId remote control id
     */
    void onButtonPressed(String buttonCode);
    // This is really an awkward learning to understand that the original class is changing, in conversation,
    // and not in a new commit in the repo. Henceforth, I urge you not to do so because I wasted my time trying
    // to do useless stuff.
}