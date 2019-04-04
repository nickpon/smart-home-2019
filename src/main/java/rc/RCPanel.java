package rc;

import java.util.HashMap;
import java.util.Map;


public class RCPanel implements RemoteControl {
    private final Map<String, Command> buttons = new HashMap<>();

    public RCPanel() {
    }

    public void registerCommand(String buttonCode, Command command) {
        buttons.put(buttonCode,command);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (buttons.containsKey(buttonCode))
        {
            buttons.get(buttonCode).execute();
        }
    }
}