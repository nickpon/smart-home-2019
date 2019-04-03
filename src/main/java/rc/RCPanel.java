package rc;

import java.util.HashMap;
import java.util.Map;


public class RCPanel implements RemoteControl {
    private Map<String, InterfaceCommand> buttons;
    public RCPanel() {
        buttons = new HashMap<>();
    }

    public void setingCommand(String buttonCode,  InterfaceCommand command) {
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