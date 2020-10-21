package cat.yoink.clientapi.component;

import cat.yoink.clientapi.ClientAPI;
import org.reflections.Reflections;

import java.util.ArrayList;

public class ComponentManager
{
    private final ArrayList<Component> components = new ArrayList<>();

    public ComponentManager()
    {
        for (Class<?> aClass : new Reflections(ClientAPI.getMasterPackage() != null ? ClientAPI.getMasterPackage().getName() : "").getSubTypesOf(Component.class))
        {
            try { components.add((Component) aClass.getConstructor().newInstance()); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public ArrayList<Component> getComponents()
    {
        return components;
    }
}
