package Lambda_Expressions;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        
        Map<String, LightBehavior> lightBehaviors = new HashMap<>();

        lightBehaviors.put("motion", () -> System.out.println("Lights ON with soft white glow for motion detection."));
        lightBehaviors.put("night", () -> System.out.println("Dim warm lights ON for night mode."));
        lightBehaviors.put("voice", () -> System.out.println("Lights change color to blue via voice command."));
        lightBehaviors.put("party", () -> System.out.println("Lights flash in multiple colors for party mode."));
        
        triggerLight("motion", lightBehaviors);
        triggerLight("night", lightBehaviors);
        triggerLight("voice", lightBehaviors);
        triggerLight("party", lightBehaviors);
        triggerLight("unknown", lightBehaviors);
    }

    public static void triggerLight(String trigger, Map<String, LightBehavior> behaviors) {
        LightBehavior behavior = behaviors.get(trigger);
        if (behavior != null) {
            System.out.print(trigger.toUpperCase() + " Trigger: ");
            behavior.activate();
        } else {
            System.out.println(trigger.toUpperCase() + " Trigger: No light pattern assigned.");
        }
    }
}
