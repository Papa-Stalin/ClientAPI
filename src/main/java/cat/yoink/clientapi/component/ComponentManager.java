package cat.yoink.clientapi.component;

import org.reflections.Reflections;

import java.util.ArrayList;

public class ComponentManager
{
    private final ArrayList<Component> components = new ArrayList<>();

    public ComponentManager()
    {
        for (Class<?> aClass : new Reflections("").getSubTypesOf(Component.class))
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
